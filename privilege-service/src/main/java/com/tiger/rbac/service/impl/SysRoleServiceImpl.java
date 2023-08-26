package com.tiger.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiger.rbac.mapper.SysRoleMapper;
import com.tiger.rbac.model.po.SysRole;
import com.tiger.rbac.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 21:25
 * @Description
 * @Version: 1.0
 **/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Override
    public IPage<SysRole> listByPage(Integer pageSize, Integer pageNum) {
        Page<SysRole> page = new Page<>(pageNum, pageSize);
        return page(page);
    }

    @Override
    public List<SysRole> listByUser(Long userId) {
        return this.getBaseMapper().selectByUser(userId);
    }
}
