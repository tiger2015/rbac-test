package com.tiger.rbac.auth;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Zenghu
 * @Date 2023年09月03日 10:23
 * @Description
 * @Version: 1.0
 **/
@Data
public class AuthenticationResult implements Serializable {
    private static final long serialVersionUID = 4833195206238615617L;
    private String token;
}
