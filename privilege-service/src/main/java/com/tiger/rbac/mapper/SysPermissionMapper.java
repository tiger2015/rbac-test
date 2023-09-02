package com.tiger.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tiger.rbac.model.po.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:18
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    List<SysPermission> selectByRole(@Param("roleId") Integer roleId);
    List<SysPermission> selectByUser(@Param("userId") Integer userId);
}
