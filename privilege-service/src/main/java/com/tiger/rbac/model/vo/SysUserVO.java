package com.tiger.rbac.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:19
 * @Description
 * @Version: 1.0
 **/
@Data
public class SysUserVO implements Serializable {
    private static final long serialVersionUID = -7471761220989292428L;
    private Integer id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private LocalDateTime modifiedTime;
}
