package com.tiger.rbac.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:20
 * @Description
 * @Version: 1.0
 **/
@Data
public class SysUserDTO implements Serializable {
    private static final long serialVersionUID = 1937357848096294389L;
    private Integer id;
    private String name;
    private String password;
}
