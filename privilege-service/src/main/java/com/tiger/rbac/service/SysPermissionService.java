package com.tiger.rbac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tiger.rbac.model.po.SysPermission;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:36
 * @Description
 * @Version: 1.0
 **/
public interface SysPermissionService extends IService<SysPermission> {
    /**
     * 分页查询权限
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    IPage<SysPermission> listByPage(Integer pageSize, Integer pageNum);

    /**
     * 查询角色权限
     *
     * @param roleId
     * @return
     */
    List<SysPermission> listByRoleId(Integer roleId);

    /**
     * 查询用户权限
     *
     * @param userId
     * @return
     */
    List<SysPermission> listByUserId(Long userId);
}
