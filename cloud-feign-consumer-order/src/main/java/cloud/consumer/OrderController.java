package cloud.consumer;

import club.wetech.cloud.common.dto.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author leven.chen
 */
@RestController
@RequestMapping("/api/consumer/order")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private PaymentServiceFeignClient paymentServiceFeignClient;

    @GetMapping("/pay/{orderId}")
    public Result<String> orderPay(@PathVariable String orderId) {
        log.info("zookeeper 订单ID={} 校验合法性", orderId);
        log.info("zookeeper 订单ID={} 执行付款", orderId);
        Result<String> result = paymentServiceFeignClient.doPayment(orderId);
        return result;
    }

    @GetMapping("/slow-pay/{orderId}")
    public Result<String> slowPayment(@PathVariable String orderId){
        Result<String> result = paymentServiceFeignClient.doSlowPayment(orderId);
        return result;
    }
}
