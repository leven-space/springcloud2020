package clud.wetch.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author leven.chen
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigServiceApplication.class, args);
    }
}
