package com.tiger.rbac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tiger.rbac.model.po.SysUser;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:35
 * @Description
 * @Version: 1.0
 **/
public interface SysUserService extends IService<SysUser> {
    /**
     * 分页查询用列表
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    IPage<SysUser> listByPage(Integer pageSize, Integer pageNum);
}
