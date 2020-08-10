package cloud.consumer;

import club.wetech.cloud.common.dto.Result;
import club.wetech.cloud.common.util.ResultBuilder;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leven.chen
 */
@RestController
@RequestMapping("/api/consumer/order")
@DefaultProperties(defaultFallback = "defaultFallbackMethod")
public class OrderController {

    @Autowired
    private PaymentFeignClient paymentClient;

    @GetMapping("/pay/{orderId}")
    public Result<String> orderPay(@PathVariable String orderId) {
        return paymentClient.doPayment(orderId);
    }

    @GetMapping("/feignclient-fallback-pay/{orderId}")
    public Result<String> feignClientFallbackOrderPay(@PathVariable String orderId) {
        return paymentClient.doSlowPayment(orderId);
    }

    /**
     * 使用默认的降级方法
     * 根据@DefaultProperties指定的方法进行降级处理
     */
    @HystrixCommand
    @GetMapping("/default-fallback-pay/{orderId}")
    public Result<String> defaultFallbackOrderPay(@PathVariable String orderId) {
        return paymentClient.doSlowPayment(orderId);
    }

    /**
     * 生产者侧-自定义的降级处理
     */
    @GetMapping("/error-pay/{orderId}")
    public Result<String> orderErrorPay(@PathVariable String orderId) {
        return paymentClient.doErrorPayment(orderId);
    }


    /**
     * 消费者侧-使用自定义的降级处理 并指定客户端等待超时时间
     */
    @HystrixCommand(fallbackMethod = "fallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @GetMapping("/slow-pay/{orderId}")
    public Result<String> orderSlowPay(@PathVariable String orderId) {
        return paymentClient.doSlowPayment(orderId);
    }


    public Result<String> fallbackMethod(String orderId) {
        return ResultBuilder.success("orderId=" + orderId + "调用付款服务失败或自己错误，请稍后再试");
    }

    public Result<String> defaultFallbackMethod() {
        return ResultBuilder.success("服务默认处理方法-调用付款服务失败或自己错误，请稍后再试");
    }
}
