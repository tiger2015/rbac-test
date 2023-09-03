package com.tiger.rbac.model.converter;

import com.tiger.rbac.model.dto.SysPermissionDTO;
import com.tiger.rbac.model.po.SysPermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author Zenghu
 * @Date 2023年09月03日 10:33
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface SysPermissionConverter {

    SysPermissionConverter INSTANCE = Mappers.getMapper(SysPermissionConverter.class);

    SysPermission dtoToPo(SysPermissionDTO dto);

}
