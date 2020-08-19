package club.wetech.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leven.chen
 */
@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        String uri = "http://localhost:9001/";
        routes.route("slow-payment-2",
                r -> r.path("/api/payment/slowPayment/**")
                        .uri(uri));
        return routes.build();
    }
}
