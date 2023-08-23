package com.tiger.rbac.privilege.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:30
 * @Description
 * @Version: 1.0
 **/
@Data
public class RolePrivilegeDTO implements Serializable {
    private static final long serialVersionUID = 1474075388023726179L;
    private Integer roleId;
    private Integer privilegeId;
}
