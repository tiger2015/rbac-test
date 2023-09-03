package com.tiger.rbac.model.converter;

import com.tiger.rbac.model.dto.SysRoleDTO;
import com.tiger.rbac.model.po.SysRole;
import com.tiger.rbac.model.vo.SysRoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author Zenghu
 * @Date 2023年08月29日 22:04
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface SysRoleConverter {
    SysRoleConverter INSTANCE = Mappers.getMapper(SysRoleConverter.class);

    SysRole dtoToPo(SysRoleDTO dto);
    SysRoleVO poToVo(SysRole po);
}
