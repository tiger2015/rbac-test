package com.tiger.rbac.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:29
 * @Description
 * @Version: 1.0
 **/
@Data
public class SysUserRoleDTO implements Serializable {
    private static final long serialVersionUID = -6999101504363943800L;
    private Integer userId;
    private Integer roleId;
}