package com.tiger.rbac.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @Author Zenghu
 * @Date 2023年07月02日 9:18
 * @Description
 * @Version: 1.0
 **/
@Table("sys_role_permission")
@Data
public class SysRolePermission extends BaseInfo {
    @TableField("role_id")
    private Integer roleId;
    @TableField("permission_id")
    private Integer permissionId;
}
