package cloud.provider;

import club.wetech.cloud.common.dto.Result;
import club.wetech.cloud.common.util.ResultBuilder;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author leven.chen
 */
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
    @Value("${server.port}")
    private String port;

    @GetMapping("/doPayment/{orderId}")
    public Result<String> doPayment(@PathVariable String orderId) {
        log.info("orderId={} 已支付成功 服务端口={}", orderId, port);
        String msg = "orderId=" + orderId + "支付成功，port=" + port;
        return ResultBuilder.success(msg);
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @GetMapping("/slowPayment/{orderId}")
    public Result<String> doSlowPayment(@PathVariable String orderId) throws InterruptedException {
        log.info("orderId={} 已支付成功 服务端口={}", orderId, port);
        TimeUnit.SECONDS.sleep(4);
        String msg = "orderId=" + orderId + "支付成功，port=" + port;
        return ResultBuilder.success(msg);
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    @GetMapping("/errorPayment/{orderId}")
    public Result<String> doErrorPayment(@PathVariable String orderId) {
        int a = 3 / 0;
        String msg = "orderId=" + orderId + "支付成功，port=" + port;
        return ResultBuilder.success(msg);
    }

    public Result<String> fallbackMethod(String orderId) {
        return ResultBuilder.success("orderId=" + orderId + "付款错误，请稍后再试");
    }

}
