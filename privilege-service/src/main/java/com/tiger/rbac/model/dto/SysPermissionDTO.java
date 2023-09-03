package com.tiger.rbac.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:28
 * @Description
 * @Version: 1.0
 **/
@Data
public class SysPermissionDTO implements Serializable {
    private static final long serialVersionUID = 5496677952396179454L;
    private Integer id;
    private String name;
    private String perms;
    private Integer order;
    private String description;
    private Integer parent;
}
