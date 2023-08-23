package com.tiger.rbac.privilege.model.converter;

import com.tiger.rbac.privilege.model.dto.PrivilegeDTO;
import com.tiger.rbac.privilege.model.po.Privilege;
import com.tiger.rbac.privilege.model.vo.PrivilegeDetailVO;
import com.tiger.rbac.privilege.model.vo.PrivilegeVO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 16:26
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface PrivilegeConverter {
    PrivilegeConverter INSTANCE = Mappers.getMapper(PrivilegeConverter.class);

    @Mapping(target = "pid", source = "parent")
    @Mapping(target = "parent", ignore = true)
    Privilege dtoToPo(PrivilegeDTO privilegeDTO);

    @Named("poToVo")
    PrivilegeVO poToVo(Privilege privilege);

    @IterableMapping(qualifiedByName = "poToVo")
    List<PrivilegeVO> poToVoList(List<Privilege> privilegeList);


    @Named("poToDetailVo")
    PrivilegeDetailVO poToDetailVo(Privilege privilege);

    @IterableMapping(qualifiedByName = "poToDetailVo")
    List<PrivilegeDetailVO> poToDetailVoList(List<Privilege> privileges);


}
