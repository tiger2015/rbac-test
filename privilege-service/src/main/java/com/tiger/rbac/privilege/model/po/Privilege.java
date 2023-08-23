package com.tiger.rbac.privilege.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @Author Zenghu
 * @Date 2023年06月23日 22:07
 * @Description
 * @Version: 1.0
 **/
@Table("privilege")
@Data
public class Privilege extends BaseInfo {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField
    private String name;
    @TableField
    private String title;
    @TableField
    private String path;
    @TableField
    private Long pid;
    @TableField
    private String description;
    @TableField
    private Integer order;

    @TableField(exist = false)
    private Privilege parent;
}
