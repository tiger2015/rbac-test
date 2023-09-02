package com.tiger.rbac.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:32
 * @Description
 * @Version: 1.0
 **/
@Data
public class SysPermissionVO implements Serializable {
    private static final long serialVersionUID = 309505352217566756L;
    private Integer id;
    private String name;
    private String perms;
    private String description;
    private Integer pid;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
}
