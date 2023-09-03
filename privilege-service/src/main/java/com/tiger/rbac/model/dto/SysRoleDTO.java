package com.tiger.rbac.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:21
 * @Description
 * @Version: 1.0
 **/
@Data
public class SysRoleDTO implements Serializable {
    private static final long serialVersionUID = 432004256423572611L;
    private Integer id;
    private String name;
    private String code;
    private String description;
}
