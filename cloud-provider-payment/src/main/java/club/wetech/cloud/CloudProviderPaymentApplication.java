package club.wetech.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author leven.chen
 */
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPaymentApplication.class, args);
    }

}
