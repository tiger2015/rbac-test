package com.tiger.rbac.controller;

import com.tiger.rbac.model.dto.UserDTO;
import com.tiger.rbac.model.vo.UserVO;
import com.tiger.rbac.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Zenghu
 * @Date 2023年07月08日 11:35
 * @Description
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/add")
    public Long add(UserDTO userDTO) {

        return null;
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/info/{id}")
    public UserVO info(@PathVariable("id") Long id) {

        return null;
    }


}
