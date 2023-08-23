package com.tiger.rbac.privilege.service.impl;

import com.tiger.rbac.common.entity.PageData;
import com.tiger.rbac.privilege.mapper.RoleMapper;
import com.tiger.rbac.privilege.mapper.RolePrivilegeMapper;
import com.tiger.rbac.privilege.model.converter.PrivilegeConverter;
import com.tiger.rbac.privilege.model.converter.RoleConverter;
import com.tiger.rbac.privilege.model.converter.RolePrivilegeConverter;
import com.tiger.rbac.privilege.model.dto.RoleDTO;
import com.tiger.rbac.privilege.model.dto.RolePrivilegeDTO;
import com.tiger.rbac.privilege.model.po.Privilege;
import com.tiger.rbac.privilege.model.po.Role;
import com.tiger.rbac.privilege.model.po.RolePrivilege;
import com.tiger.rbac.privilege.model.vo.PrivilegeVO;
import com.tiger.rbac.privilege.model.vo.RoleVO;
import com.tiger.rbac.privilege.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 21:25
 * @Description
 * @Version: 1.0
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePrivilegeMapper rolePrivilegeMapper;

    @Override
    public Integer add(RoleDTO roleDTO) {
        Role role = RoleConverter.INSTANCE.dtoToPo(roleDTO);
        roleMapper.insert(role);
        return role.getId();
    }

    @Override
    public int remove(Long id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public PageData<RoleVO> listByPage(int pageSize, int pageNum) {




        return null;
    }

    @Override
    public List<RoleVO> listUserRole(Long userId) {
        return null;
    }

    @Override
    public int grantPrivileges(List<RolePrivilegeDTO> privilegeDTOList) {
        List<RolePrivilege> rolePrivileges = RolePrivilegeConverter.INSTANCE.dtoToPoList(privilegeDTOList);
        return rolePrivilegeMapper.insertBatch(rolePrivileges);
    }

    @Override
    public List<PrivilegeVO> listPrivileges(Long id) {
        List<Privilege> privileges = roleMapper.selectPrivileges(id);
        return PrivilegeConverter.INSTANCE.poToVoList(privileges);
    }

    @Override
    public int revokePrivilege(Long roleId, Long privilegeId) {
        return rolePrivilegeMapper.delete(roleId, privilegeId);
    }
}
