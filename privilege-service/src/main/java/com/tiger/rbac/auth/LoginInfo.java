package com.tiger.rbac.auth;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Zenghu
 * @Date 2023年08月31日 21:58
 * @Description
 * @Version: 1.0
 **/
@Data
public class LoginInfo implements Serializable {
    private static final long serialVersionUID = -7379200645194681548L;
    private String username;
    private String password;
    private String verifyCode;
}
