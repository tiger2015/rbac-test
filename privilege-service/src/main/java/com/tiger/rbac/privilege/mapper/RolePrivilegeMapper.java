package com.tiger.rbac.privilege.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tiger.rbac.privilege.model.po.RolePrivilege;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年07月02日 9:25
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface RolePrivilegeMapper extends BaseMapper<RolePrivilege> {

    int insertBatch(@Param("list") List<RolePrivilege> rolePrivilegeList);

    int delete(@Param("roleId") Long roleId, @Param("privilegeId") Long privilegeId);
}
