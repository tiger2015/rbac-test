package com.tiger.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiger.rbac.mapper.SysUserMapper;
import com.tiger.rbac.model.po.SysUser;
import com.tiger.rbac.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 13:08
 * @Description
 * @Version: 1.0
 **/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public IPage<SysUser> listByPage(Integer pageSize, Integer pageNum) {
        Page<SysUser> page = new Page<>(pageNum, pageSize);
        return page(page);
    }
}
