package com.tiger.rbac.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @Author Zenghu
 * @Date 2023年06月23日 10:56
 * @Description
 * @Version: 1.0
 **/
@Table("sys_role")
@Data
public class SysRole extends BaseInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField
    private String name;
    @TableField
    private String description;
    @TableLogic
    private Integer isDeleted;
}
