package com.tiger.rbac.privilege.model.converter;

import com.tiger.rbac.privilege.model.dto.RoleDTO;
import com.tiger.rbac.privilege.model.po.Role;
import com.tiger.rbac.privilege.model.vo.RoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 16:00
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface RoleConverter {
    RoleConverter INSTANCE = Mappers.getMapper(RoleConverter.class);

    Role dtoToPo(RoleDTO roleDTO);

    RoleVO poToVo(Role role);

    List<RoleVO> poToVoList(List<Role> roleList);
}
