package cloud.consumer;

import club.wetech.cloud.common.dto.Result;
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
public class OrderController {

    @Autowired
    private PaymentFeignClient paymentClient;

    @GetMapping("/pay/{orderId}")
    public Result<String> orderPay(@PathVariable String orderId) {
        return paymentClient.doPayment(orderId);
    }

    @GetMapping("/slow-pay/{orderId}")
    public Result<String> orderSlowPay(@PathVariable String orderId) throws InterruptedException {
        return paymentClient.doSlowPayment(orderId);
    }

    @GetMapping("/error-pay/{orderId}")
    public Result<String> orderErrorPay(@PathVariable String orderId) {
        return paymentClient.doErrorPayment(orderId);
    }
}
