package com.tiger.rbac.controller;

import com.tiger.rbac.common.result.ResponseResult;
import com.tiger.rbac.model.converter.SysPermissionConverter;
import com.tiger.rbac.model.dto.SysPermissionDTO;
import com.tiger.rbac.model.po.SysPermission;
import com.tiger.rbac.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Zenghu
 * @Date 2023年09月03日 10:32
 * @Description
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/permission")
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @PostMapping("/add")
    public ResponseResult<Object> add(@RequestBody SysPermissionDTO permissionDTO) {
        SysPermission sysPermission = SysPermissionConverter.INSTANCE.dtoToPo(permissionDTO);
        sysPermissionService.save(sysPermission);
        return ResponseResult.success(sysPermission.getId());
    }


}
