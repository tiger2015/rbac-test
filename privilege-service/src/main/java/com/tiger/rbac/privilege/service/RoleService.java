package com.tiger.rbac.privilege.service;

import com.tiger.rbac.common.entity.PageData;
import com.tiger.rbac.privilege.model.dto.RoleDTO;
import com.tiger.rbac.privilege.model.dto.RolePrivilegeDTO;
import com.tiger.rbac.privilege.model.vo.PrivilegeVO;
import com.tiger.rbac.privilege.model.vo.RoleVO;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:36
 * @Description
 * @Version: 1.0
 **/
public interface RoleService {
    /**
     * 添加角色
     *
     * @param roleDTO 角色信息
     * @return
     */
    Integer add(RoleDTO roleDTO);

    /**
     * 根据ID删除角色
     *
     * @param id 角色ID
     * @return
     */
    int remove(Long id);

    /**
     * 分页查询角色列表
     *
     * @param pageSize 页大小
     * @param pageNum  页号
     * @return
     */
    PageData<RoleVO> listByPage(int pageSize, int pageNum);

    /**
     * 查询用户角色
     *
     * @param userId 用户ID
     * @return
     */
    List<RoleVO> listUserRole(Long userId);

    /**
     * 给角色授权
     *
     * @param privilegeDTOList 权限列表
     * @return
     */
    int grantPrivileges(List<RolePrivilegeDTO> privilegeDTOList);

    /**
     * 获取角色的所有权限
     *
     * @param id 角色ID
     * @return
     */
    List<PrivilegeVO> listPrivileges(Long id);

    /**
     * 收回角色的权限
     *
     * @param roleId      角色ID
     * @param privilegeId 权限ID
     * @return
     */
    int revokePrivilege(Long roleId, Long privilegeId);
}
