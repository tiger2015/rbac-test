package com.tiger.rbac.privilege.controller;

import com.tiger.rbac.privilege.model.dto.UserDTO;
import com.tiger.rbac.privilege.model.vo.UserVO;
import com.tiger.rbac.privilege.service.UserService;
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
    private UserService userService;

    @PostMapping("/add")
    public Long add(UserDTO userDTO) {
        return userService.add(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable("id") Long id){
        return userService.delete(id);
    }

    @GetMapping("/info/{id}")
    public UserVO info(@PathVariable("id") Long id){

        return null;
    }



}
