package cloud.consumer;

import club.wetech.cloud.common.dto.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author leven.chen
 */
@Component
@FeignClient(value = "cloud-provider-payment", fallback = PaymentFeignClientFallbackImpl.class)
public interface PaymentFeignClient {

    @GetMapping("/api/payment/doPayment/{orderId}")
    Result<String> doPayment(@PathVariable("orderId") String orderId);

    @GetMapping("/api/payment/slowPayment/{orderId}")
    Result<String> doSlowPayment(@PathVariable("orderId") String orderId);


    @GetMapping("/api/payment/errorPayment/{orderId}")
    Result<String> doErrorPayment(@PathVariable("orderId") String orderId);
}
