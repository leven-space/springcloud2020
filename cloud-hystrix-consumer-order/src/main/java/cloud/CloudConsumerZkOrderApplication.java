package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author leven.chen
 */
@SpringBootApplication
@Configuration
@EnableFeignClients
public class CloudConsumerZkOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerZkOrderApplication.class, args);
    }


}
