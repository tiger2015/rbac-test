package com.tiger.rbac.privilege.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年06月23日 10:55
 * @Description
 * @Version: 1.0
 **/
@Table(value = "user")
@Data
public class User extends BaseInfo {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField
    private String name;
    @TableField
    private String password;

    @TableField(exist = false)
    private List<Role> roles;
}
