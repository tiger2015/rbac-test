package com.tiger.rbac.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class SysRoleDTO implements Serializable {
    private static final long serialVersionUID = 432004256423572611L;
    private Integer id;
    private String name;
    private String code;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private LocalDateTime modifiedTime;
}
