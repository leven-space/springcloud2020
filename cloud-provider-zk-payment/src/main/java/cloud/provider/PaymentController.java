package cloud.provider;

import club.wetech.cloud.common.dto.Result;
import club.wetech.cloud.common.util.ResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
