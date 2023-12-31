package com.tiger.rbac.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Zenghu
 * @Date 2023年08月02日 21:34
 * @Description
 * @Version: 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayService {
    public static void main(String[] args) {
        SpringApplication.run(GatewayService.class, args);
    }
}
