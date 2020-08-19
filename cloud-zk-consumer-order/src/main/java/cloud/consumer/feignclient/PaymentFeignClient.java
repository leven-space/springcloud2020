package cloud.consumer.feignclient;

import club.wetech.cloud.common.dto.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author leven.chen
 */
@Service
@FeignClient(name = "cloud-provider-payment")
public interface PaymentFeignClient {

    @GetMapping("/api/payment/slowPayment/{orderId}")
    Result<String> doSlowPayment(@PathVariable("orderId") String orderId);


}
