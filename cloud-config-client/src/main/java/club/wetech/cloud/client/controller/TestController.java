package club.wetech.cloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leven.chen
 */
@RestController
public class TestController {
    @Value("${config.env}")
    private String config;
    @Autowired
    private DemoProperties properties;

    @GetMapping("/by-@value")
    public String getConfig(){
        return config;
    }

    @GetMapping("/byBean")
    public void getConfigByBean(){
        System.out.println(properties.getEnv());
        System.out.println(properties.getUsername());
    }
}
