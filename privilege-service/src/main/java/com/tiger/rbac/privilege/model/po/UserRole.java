package com.tiger.rbac.privilege.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @Author Zenghu
 * @Date 2023年07月02日 9:22
 * @Description
 * @Version: 1.0
 **/
@Table("user_role")
@Data
public class UserRole extends BaseInfo {
    @TableField("user_id")
    private Long userId;
    @TableField("role_id")
    private Integer roleId;
}
