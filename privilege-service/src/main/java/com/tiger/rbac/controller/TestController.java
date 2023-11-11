package com.tiger.rbac.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tiger.rbac.common.result.ResponseResult;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Zenghu
 * @Date 2023年10月12日 21:08
 * @Description
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/list")
    public ResponseResult<UserInfo> list() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(0L);
        userInfo.setName("admin");
        userInfo.setParams(new HashMap<>());
        return ResponseResult.success(userInfo);
    }


    @Data
    public static class UserInfo implements Serializable {
        private static final long serialVersionUID = 3217660952070043708L;
        private Long id;
        private String name;
        private String password;
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Map<String, Object> params;
    }


}
