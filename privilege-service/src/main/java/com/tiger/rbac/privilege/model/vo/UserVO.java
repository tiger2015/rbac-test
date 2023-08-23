package com.tiger.rbac.privilege.model.vo;

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
public class UserVO implements Serializable {
    private static final long serialVersionUID = -7471761220989292428L;
    private Long id;
    private String name;
    private String password;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
}
