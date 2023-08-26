package com.tiger.rbac.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @Author Zenghu
 * @Date 2023年06月23日 22:07
 * @Description
 * @Version: 1.0
 **/
@Table("sys_permission")
@Data
public class SysPermission extends BaseInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField
    private String name;
    /**
     * 权限标识
     */
    @TableField
    private String perms;
    @TableField
    private Integer order;
    @TableField
    private String description;
    @TableField
    private Integer pid;
    @TableLogic
    private Integer isDeleted;
}
