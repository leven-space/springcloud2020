package ribbonrules;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leven.chen
 */
@Configuration
public class PaymentRibbonRuleConfig {

    @Bean
    public IRule randomRule(){
        return new RandomRule();
    }
}
