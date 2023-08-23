package com.tiger.rbac.privilege.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @Author Zenghu
 * @Date 2023年07月02日 9:18
 * @Description
 * @Version: 1.0
 **/
@Table("role_privilege")
@Data
public class RolePrivilege extends BaseInfo {
    @TableField("role_id")
    private Integer roleId;
    @TableField("privilege_id")
    private Integer privilegeId;
}
