package com.tiger.rbac.privilege.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年06月23日 10:56
 * @Description
 * @Version: 1.0
 **/
@Table("role")
@Data
public class Role extends BaseInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField
    private String name;
    @TableField
    private String description;

    @TableField(exist = false)
    private List<Privilege> privileges;
}
