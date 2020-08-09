package club.wetech.cloud.provider;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author leven.chen
 */
@RestController
@RequestMapping("/discovery")
public class DiscoveryController {

    private static final Logger log = LoggerFactory.getLogger(DiscoveryController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/list")
    public String getList() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("***** registered service name={}",service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-club.wetech.cloud.provider.provider-payment");
        for (ServiceInstance instance : instances) {
            log.info("***** cloud-club.wetech.cloud.provider.provider-payment access uri={}",instance.getUri());

        }
        return discoveryClient.description();
    }
}
