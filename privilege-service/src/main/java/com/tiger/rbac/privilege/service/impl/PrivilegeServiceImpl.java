package com.tiger.rbac.privilege.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tiger.rbac.common.entity.PageData;
import com.tiger.rbac.privilege.mapper.PrivilegeMapper;
import com.tiger.rbac.privilege.model.converter.PrivilegeConverter;
import com.tiger.rbac.privilege.model.dto.PrivilegeDTO;
import com.tiger.rbac.privilege.model.po.Privilege;
import com.tiger.rbac.privilege.model.vo.PrivilegeDetailVO;
import com.tiger.rbac.privilege.model.vo.PrivilegeTree;
import com.tiger.rbac.privilege.model.vo.PrivilegeVO;
import com.tiger.rbac.privilege.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Zenghu
 * @Date 2023年07月08日 11:32
 * @Description
 * @Version: 1.0
 **/
@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Override
    public Integer add(PrivilegeDTO privilegeDTO) {
        Privilege privilege = PrivilegeConverter.INSTANCE.dtoToPo(privilegeDTO);
        privilegeMapper.insert(privilege);
        return privilege.getId();
    }

    @Override
    public int remove(Long id) {
        return privilegeMapper.deleteById(id);
    }

    @Override
    public PageData<PrivilegeVO> listByPage(int pageSize, int pageNum) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Privilege> privileges = privilegeMapper.selectAll();
            PageInfo<Privilege> pageInfo = new PageInfo<>(privileges);
            PageData<PrivilegeVO> pageData = new PageData<>();
            pageData.setPageNum(pageInfo.getPageNum());
            pageData.setPageSize(pageInfo.getPageSize());
            pageData.setTotalPage(pageInfo.getPages());
            pageData.setTotal(pageInfo.getTotal());
            pageData.setData(PrivilegeConverter.INSTANCE.poToVoList(pageInfo.getList()));
            return pageData;
        } finally {
            PageHelper.clearPage();
        }
    }

    @Override
    public PrivilegeDetailVO listPrivileges() {
        List<Privilege> privileges = privilegeMapper.selectAll();
        List<PrivilegeVO> privilegeVOS = PrivilegeConverter.INSTANCE.poToVoList(privileges);
        Map<Integer, PrivilegeTree> treeNodes = new HashMap<>();




        List<PrivilegeDetailVO> privilegeDetailVOS = PrivilegeConverter.INSTANCE.poToDetailVoList(privileges);








        return null;
    }
}
