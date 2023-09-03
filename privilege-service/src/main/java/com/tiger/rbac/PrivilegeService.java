package com.tiger.rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @Author Zenghu
 * @Date 2023年06月22日 17:05
 * @Description
 * @Version: 1.0
 **/
@SpringBootApplication
@ComponentScans(@ComponentScan(basePackages = {"com.tiger.rbac.common.controller"}))
//@EnableDiscoveryClient
public class PrivilegeService {
    public static void main(String[] args) {
        SpringApplication.run(PrivilegeService.class, args);
    }
}
