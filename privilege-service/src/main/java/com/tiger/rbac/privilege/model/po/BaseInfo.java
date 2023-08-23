package com.tiger.rbac.privilege.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author Zenghu
 * @Date 2023年06月23日 10:53
 * @Description
 * @Version: 1.0
 **/
@Data
public abstract class BaseInfo {
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "mod_time", fill = FieldFill.UPDATE)
    private LocalDateTime modifiedTime;
}
