package com.tiger.rbac.privilege.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:28
 * @Description
 * @Version: 1.0
 **/
@Data
public class PrivilegeDTO implements Serializable {
    private static final long serialVersionUID = 5496677952396179454L;
    private Integer id;
    private String name;
    private String path;
    private String title;
    private Integer sort;
    private String description;
    private Integer parent;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
}
