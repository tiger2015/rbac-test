package com.tiger.rbac.model.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @Author Zenghu
 * @Date 2023年06月23日 10:55
 * @Description
 * @Version: 1.0
 **/
@Table(value = "sys_user")
@Data
public class SysUser extends BaseInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField
    private String name;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String password;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String salt;
    @TableLogic
    private Integer isDeleted;
}
