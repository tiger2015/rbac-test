package com.tiger.rbac.model.converter;

import com.tiger.rbac.model.dto.SysUserDTO;
import com.tiger.rbac.model.po.SysUser;
import com.tiger.rbac.model.vo.SysUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @Author Zenghu
 * @Date 2023年08月27日 21:35
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface SysUserConverter {

    SysUserConverter INSTANCE = Mappers.getMapper(SysUserConverter.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "createTime", target = "createTime")
    @Mapping(source = "modifiedTime", target = "modifiedTime")
    SysUser dtoToPo(SysUserDTO dto);

    SysUserVO poToVo(SysUser sysUser);

}
