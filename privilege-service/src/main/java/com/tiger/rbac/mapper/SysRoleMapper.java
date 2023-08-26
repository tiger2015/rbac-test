package com.tiger.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tiger.rbac.model.po.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:17
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> selectByUser(@Param("userId") Long userId);
}
