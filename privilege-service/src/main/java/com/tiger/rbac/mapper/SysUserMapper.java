package com.tiger.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tiger.rbac.model.po.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:17
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
