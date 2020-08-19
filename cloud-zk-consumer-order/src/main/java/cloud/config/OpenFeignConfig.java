package cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leven.chen
 */
@Configuration
public class OpenFeignConfig {

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }
}
