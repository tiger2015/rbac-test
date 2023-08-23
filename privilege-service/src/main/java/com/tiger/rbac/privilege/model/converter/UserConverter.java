package com.tiger.rbac.privilege.model.converter;

import com.tiger.rbac.privilege.model.dto.UserDTO;
import com.tiger.rbac.privilege.model.po.User;
import com.tiger.rbac.privilege.model.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 15:56
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Mapping(target = "roles", ignore = true)
    User dtoToPo(UserDTO userDTO);

    UserVO poToVo(User user);

    List<UserVO> poToVoList(List<User> userList);
}
