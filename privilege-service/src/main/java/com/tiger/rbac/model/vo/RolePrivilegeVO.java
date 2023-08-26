package com.tiger.rbac.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Zenghu
 * @Date 2023年07月09日 10:51
 * @Description
 * @Version: 1.0
 **/
@Data
public class RolePrivilegeVO implements Serializable {
    private static final long serialVersionUID = -5575243209991905734L;
    private RoleVO role;
    private PrivilegeVO privilege;
}
