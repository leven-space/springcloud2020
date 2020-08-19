package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ribbonrules.PaymentRibbonRuleConfig;

/**
 * @author leven.chen
 */
@SpringBootApplication
@Configuration
@RibbonClients(value = {@RibbonClient(name = "cloud-provider-payment", configuration = PaymentRibbonRuleConfig.class)})
@EnableFeignClients
public class CloudConsumerZkOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerZkOrderApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }
}
