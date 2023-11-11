package com.tiger.rbac.auth;

import com.tiger.rbac.model.po.SysPermission;
import com.tiger.rbac.model.po.SysUser;
import com.tiger.rbac.service.SysPermissionService;
import com.tiger.rbac.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年08月30日 21:22
 * @Description
 * @Version: 1.0
 **/
@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysPermissionService sysPermissionService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.selectByName(username);
        SysUserDetails sysUserDetails = new SysUserDetails();
        sysUserDetails.setUsername(sysUser.getName());
       // sysUserDetails.setPassword(sysUser.getPassword());
        // 密码要重新编码，在进行密码比对时，会自动对输入的密码进行比对
        sysUserDetails.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        sysUserDetails.setLoginTime(LocalDateTime.now());
        List<SysPermission> sysPermissions = sysPermissionService.listByUserId(sysUser.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (SysPermission sysPermission : sysPermissions) {
            authorities.add(new SimpleGrantedAuthority(sysPermission.getPerms()));
        }
        sysUserDetails.setAuthorities(authorities);
        return sysUserDetails;
    }
}
