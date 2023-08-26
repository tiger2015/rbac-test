package com.tiger.rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Zenghu
 * @Date 2023年06月22日 17:05
 * @Description
 * @Version: 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PrivilegeService {
    public static void main(String[] args) {
        SpringApplication.run(PrivilegeService.class, args);
    }
}
