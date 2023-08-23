package com.tiger.rbac.privilege.service;

import com.tiger.rbac.common.entity.PageData;
import com.tiger.rbac.privilege.model.dto.UserDTO;
import com.tiger.rbac.privilege.model.vo.PrivilegeVO;
import com.tiger.rbac.privilege.model.vo.RoleVO;
import com.tiger.rbac.privilege.model.vo.UserVO;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:35
 * @Description
 * @Version: 1.0
 **/
public interface UserService {
    /**
     * 添加用户
     *
     * @param userDTO 用户信息
     * @return
     */
    Long add(UserDTO userDTO);

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return
     */
    int delete(Long id);

    /**
     * 查询用户信息
     * @param id
     * @return
     */
    UserVO get(Long id);


    /**
     * 分页查询用列表
     * @param pageSize
     * @param pageNum
     * @return
     */
    PageData<UserVO> listByPage(Integer pageSize, Integer pageNum);


    /**
     * 获取用户的角色
     *
     * @param id 用户ID
     * @return
     */
    List<RoleVO> listRoles(Long id);

    /**
     * 获取用户权限
     *
     * @param id 用户ID
     * @return
     */
    List<PrivilegeVO> listPrivileges(Long id);
}
