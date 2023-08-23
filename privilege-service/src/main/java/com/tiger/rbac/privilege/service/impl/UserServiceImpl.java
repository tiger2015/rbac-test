package com.tiger.rbac.privilege.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tiger.rbac.common.entity.PageData;
import com.tiger.rbac.privilege.mapper.UserMapper;
import com.tiger.rbac.privilege.model.converter.PrivilegeConverter;
import com.tiger.rbac.privilege.model.converter.RoleConverter;
import com.tiger.rbac.privilege.model.converter.UserConverter;
import com.tiger.rbac.privilege.model.dto.UserDTO;
import com.tiger.rbac.privilege.model.po.Privilege;
import com.tiger.rbac.privilege.model.po.Role;
import com.tiger.rbac.privilege.model.po.User;
import com.tiger.rbac.privilege.model.vo.PrivilegeVO;
import com.tiger.rbac.privilege.model.vo.RoleVO;
import com.tiger.rbac.privilege.model.vo.UserVO;
import com.tiger.rbac.privilege.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 13:08
 * @Description
 * @Version: 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Long add(UserDTO userDTO) {
        User user = UserConverter.INSTANCE.dtoToPo(userDTO);
        userMapper.insert(user);
        return user.getId();
    }

    @Override
    public int delete(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public UserVO get(Long id) {
        User user = userMapper.selectById(id);
        return UserConverter.INSTANCE.poToVo(user);
    }

    @Override
    public PageData<UserVO> listByPage(Integer pageSize, Integer pageNum) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<User> users = userMapper.selectAll();
            PageInfo<User> pageInfo = new PageInfo<>(users);
            PageData<UserVO> pageData = new PageData<>();
            pageData.setPageNum(pageInfo.getPageNum());
            pageData.setPageSize(pageInfo.getPageSize());
            pageData.setTotalPage(pageInfo.getPages());
            pageData.setTotal(pageInfo.getTotal());
            pageData.setData(UserConverter.INSTANCE.poToVoList(pageInfo.getList()));
            return pageData;
        } finally {
            PageHelper.clearPage();
        }
    }

    @Override
    public List<RoleVO> listRoles(Long id) {
        List<Role> roles = userMapper.selectRoles(id);
        return RoleConverter.INSTANCE.poToVoList(roles);
    }

    @Override
    public List<PrivilegeVO> listPrivileges(Long id) {
        List<Privilege> privileges = userMapper.selectPrivileges(id);
        return PrivilegeConverter.INSTANCE.poToVoList(privileges);
    }
}
