package club.wetech.cloud.client.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * config:
 *   env: dev
 *   username: leven
 *   version: 1
 * @author leven.chen
 */
@Component
@ConfigurationProperties("config")
public class DemoProperties {

    private String env;

    private String username;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
