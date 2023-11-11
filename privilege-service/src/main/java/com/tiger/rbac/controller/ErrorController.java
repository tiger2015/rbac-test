package com.tiger.rbac.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Zenghu
 * @Date 2023年11月09日 20:57
 * @Description
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/")
@Slf4j
public class ErrorController {

    @RequestMapping("/error/exthrow")
    public void rethrow(HttpServletRequest request) throws Exception {
        log.info("error throw");
        throw (Exception) request.getAttribute("filter.error");
    }

}
