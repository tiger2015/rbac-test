package com.tiger.rbac.privilege.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tiger.rbac.privilege.model.po.Privilege;
import com.tiger.rbac.privilege.model.po.Role;
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
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> selectAll();

    List<Privilege> selectPrivileges(@Param("roleId") Long roleId);

}
