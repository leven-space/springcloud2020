package club.wetech.cloud.provider;

import club.wetech.cloud.common.dto.Result;
import club.wetech.cloud.common.util.ResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leven.chen
 */
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @GetMapping("/doPayment/{orderId}")
    public Result<String> doPayment(String orderId){
        log.info("orderId={} 以支付成功",orderId);
        return ResultBuilder.success();
    }




}
