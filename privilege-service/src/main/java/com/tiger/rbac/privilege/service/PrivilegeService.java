package com.tiger.rbac.privilege.service;

import com.tiger.rbac.common.entity.PageData;
import com.tiger.rbac.privilege.model.dto.PrivilegeDTO;
import com.tiger.rbac.privilege.model.vo.PrivilegeDetailVO;
import com.tiger.rbac.privilege.model.vo.PrivilegeVO;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:36
 * @Description
 * @Version: 1.0
 **/
public interface PrivilegeService {
    /**
     * 添加权限
     *
     * @param privilegeDTO 权限信息
     * @return
     */
    Integer add(PrivilegeDTO privilegeDTO);

    /**
     * 删除权限
     *
     * @param id 权限ID
     * @return
     */
    int remove(Long id);

    /**
     * 分页查询权限
     * @param pageSize
     * @param pageNum
     * @return
     */
    PageData<PrivilegeVO> listByPage(int pageSize, int pageNum);

    /**
     * 查询所有的权限， 树形结构
     * @return
     */
    PrivilegeDetailVO listPrivileges();

}
