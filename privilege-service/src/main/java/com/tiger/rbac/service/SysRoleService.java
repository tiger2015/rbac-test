package com.tiger.rbac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tiger.rbac.model.po.SysRole;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:36
 * @Description
 * @Version: 1.0
 **/
public interface SysRoleService extends IService<SysRole> {
    /**
     * 分页查询角色列表
     *
     * @param pageSize 页大小
     * @param pageNum  页号
     * @return
     */
    IPage<SysRole> listByPage(Integer pageSize, Integer pageNum);

    /**
     * 查询用户角色
     *
     * @param userId
     * @return
     */
    List<SysRole> listByUser(Long userId);
}
