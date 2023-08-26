package com.tiger.rbac.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
    private Long id;
    @TableField
    private String name;
    @TableField
    private String password;
    @TableLogic
    private Integer isDeleted;
}
