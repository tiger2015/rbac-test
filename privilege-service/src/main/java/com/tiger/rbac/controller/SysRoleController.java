package com.tiger.rbac.controller;

import com.tiger.rbac.common.result.ResponseResult;
import com.tiger.rbac.model.converter.SysRoleConverter;
import com.tiger.rbac.model.dto.SysRoleDTO;
import com.tiger.rbac.model.po.SysRole;
import com.tiger.rbac.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Zenghu
 * @Date 2023年08月29日 22:02
 * @Description
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @PostMapping("/add")
    public ResponseResult<Integer> add(@RequestBody SysRoleDTO roleDTO) {
        SysRole sysRole = SysRoleConverter.INSTANCE.dtoToPo(roleDTO);
        sysRoleService.save(sysRole);
        return ResponseResult.success(sysRole.getId());
    }





}
