package com.tiger.rbac.privilege.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tiger.rbac.privilege.model.po.Privilege;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:18
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface PrivilegeMapper extends BaseMapper<Privilege> {
    List<Privilege> selectAll();
}
