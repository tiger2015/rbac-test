package com.tiger.rbac.privilege.model.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author Zenghu
 * @Date 2023年07月02日 9:29
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface UserRoleConverter {
    UserRoleConverter INSTANCE = Mappers.getMapper(UserRoleConverter.class);
}
