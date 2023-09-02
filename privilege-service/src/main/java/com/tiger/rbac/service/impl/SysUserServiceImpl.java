package com.tiger.rbac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiger.rbac.common.exception.BusinessException;
import com.tiger.rbac.common.result.ResultCode;
import com.tiger.rbac.common.utils.PasswordUtils;
import com.tiger.rbac.mapper.SysUserMapper;
import com.tiger.rbac.model.po.SysUser;
import com.tiger.rbac.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

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


    public boolean add(SysUser sysUser) throws BusinessException {
        try {
            String salt = UUID.randomUUID().toString().replace("-", "");
            String encode = PasswordUtils.encode(sysUser.getPassword(), salt);
            sysUser.setPassword(encode);
            sysUser.setSalt(salt);
            return super.save(sysUser);
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public SysUser selectByName(String name) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(true, "name", name);
        return this.getOne(queryWrapper);
    }
}
