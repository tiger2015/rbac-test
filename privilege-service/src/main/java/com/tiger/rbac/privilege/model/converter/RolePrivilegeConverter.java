package com.tiger.rbac.privilege.model.converter;

import com.tiger.rbac.privilege.model.dto.RolePrivilegeDTO;
import com.tiger.rbac.privilege.model.po.RolePrivilege;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年07月02日 9:26
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface RolePrivilegeConverter {

    RolePrivilegeConverter INSTANCE = Mappers.getMapper(RolePrivilegeConverter.class);

    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "modifiedTime", ignore = true)
    RolePrivilege dtoToPo(RolePrivilegeDTO dto);

    List<RolePrivilege> dtoToPoList(List<RolePrivilegeDTO> dtoList);
}
