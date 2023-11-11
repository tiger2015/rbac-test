package com.tiger.rbac.config;

import com.tiger.rbac.filter.ExceptionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @Author Zenghu
 * @Date 2023年11月09日 20:59
 * @Description
 * @Version: 1.0
 **/
//@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<ExceptionFilter> exceptionFilterRegistration() {
        FilterRegistrationBean<ExceptionFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new ExceptionFilter());
        registration.setName("ExceptionFilter");
        //此处尽量小，要比其他Filter靠前
        registration.setOrder(-1);
        registration.addUrlPatterns("/*");
        return registration;
    }
}
