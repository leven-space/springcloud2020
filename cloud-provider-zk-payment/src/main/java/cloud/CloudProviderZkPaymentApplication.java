package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author leven.chen
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderZkPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderZkPaymentApplication.class, args);
    }

}
