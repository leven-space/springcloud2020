package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author leven.chen
 */
@SpringBootApplication
@EnableFeignClients
public class CloudConsumerFeignOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeignOrderApplication.class, args);
    }


}
