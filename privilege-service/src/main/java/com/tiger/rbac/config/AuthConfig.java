package com.tiger.rbac.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Zenghu
 * @Date 2023年08月31日 20:31
 * @Description
 * @Version: 1.0
 **/
@Configuration
@ConfigurationProperties(prefix = "auth")
@Data
public class AuthConfig {
    private String tokenSecret;
    private Long tokenValidTime;
    private String privateKey;
}
