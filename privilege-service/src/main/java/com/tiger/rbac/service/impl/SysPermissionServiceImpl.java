package com.tiger.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiger.rbac.mapper.SysPermissionMapper;
import com.tiger.rbac.model.po.SysPermission;
import com.tiger.rbac.service.SysPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年07月08日 11:32
 * @Description
 * @Version: 1.0
 **/
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Override
    public IPage<SysPermission> listByPage(Integer pageSize, Integer pageNum) {
        Page<SysPermission> page = new Page<>(pageNum, pageSize);
        return page(page);
    }

    @Override
    public List<SysPermission> listByRoleId(Integer roleId) {
        return this.baseMapper.selectByRole(roleId);
    }

    @Override
    public List<SysPermission> listByUserId(Long userId) {
        return this.baseMapper.selectByUser(userId);
    }
}
