package com.tiger.rbac.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:21
 * @Description
 * @Version: 1.0
 **/
@Data
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 432004256423572611L;
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
}
