package com.tiger.rbac.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:31
 * @Description
 * @Version: 1.0
 **/
@Data
public class SysRoleVO implements Serializable {
    private static final long serialVersionUID = 761844211192584831L;
    private Integer id;
    private String name;
    private String code;
    private String description;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
}
