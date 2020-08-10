package cloud.consumer;

import club.wetech.cloud.common.dto.Result;
import club.wetech.cloud.common.util.ResultBuilder;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

/**
 * @author leven.chen
 */
@Service
public class PaymentFeignClientFallbackImpl implements PaymentFeignClient {
    @Override
    public Result<String> doPayment(String orderId) {
        return  ResultBuilder.success("消费者服务降级处理方法-调用付款服务失败或自己错误，请稍后再试");
    }

    @Override
    public Result<String> doSlowPayment(String orderId) {
        return ResultBuilder.success("消费者服务降级处理方法-调用付款服务失败或自己错误，请稍后再试");
    }

    @Override
    public Result<String> doErrorPayment(String orderId) {
        return ResultBuilder.success("消费者服务降级处理方法-调用付款服务失败或自己错误，请稍后再试");
    }
}
