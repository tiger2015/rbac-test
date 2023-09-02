package com.tiger.rbac.controller;

import com.tiger.rbac.common.exception.BusinessException;
import com.tiger.rbac.common.result.ResponseResult;
import com.tiger.rbac.model.converter.SysUserConverter;
import com.tiger.rbac.model.dto.SysUserDTO;
import com.tiger.rbac.model.po.SysUser;
import com.tiger.rbac.model.vo.SysUserVO;
import com.tiger.rbac.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年07月08日 11:35
 * @Description
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/add")
    public ResponseResult<Integer> add(@RequestBody SysUserDTO userDTO) throws BusinessException {
        SysUser sysUser = SysUserConverter.INSTANCE.dtoToPo(userDTO);
        sysUserService.add(sysUser);
        return ResponseResult.success(sysUser.getId());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseResult<Integer> deleteById(@PathVariable("id") Integer id) {
        boolean success = sysUserService.removeById(id);
        return ResponseResult.success(success ? 1 : 0);
    }

    @DeleteMapping("/batchDelete")
    public ResponseResult<Integer> batchDelete(@RequestBody List<Integer> ids) {
        boolean success = sysUserService.removeByIds(ids);
        return ResponseResult.success(success ? 1 : 0);
    }

    @GetMapping("/info/{id}")
    public ResponseResult<SysUserVO> info(@PathVariable("id") Integer id) {
        SysUser sysUser = sysUserService.getById(id);
        return ResponseResult.success(SysUserConverter.INSTANCE.poToVo(sysUser));
    }

    @PostMapping("/update")
    public ResponseResult<Void> update(@RequestBody SysUserDTO userDTO) {
        SysUser sysUser = SysUserConverter.INSTANCE.dtoToPo(userDTO);
        boolean success = sysUserService.updateById(sysUser);
        return ResponseResult.success();
    }
}
