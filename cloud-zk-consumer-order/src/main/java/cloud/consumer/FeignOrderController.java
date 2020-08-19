package cloud.consumer;

import cloud.consumer.feignclient.PaymentFeignClient;
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
@RequestMapping("/api/consumer/feign/order")
public class FeignOrderController {

    private static final Logger log = LoggerFactory.getLogger(FeignOrderController.class);

    @Autowired
    private PaymentFeignClient restTemplate;

    @GetMapping("/pay/{orderId}")
    public Result<String> orderPay(@PathVariable String orderId) {
        log.info("zookeeper 订单ID={} 校验合法性", orderId);
        Result<String> result = restTemplate.doSlowPayment(orderId);
        return result;
    }
}
