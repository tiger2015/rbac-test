package com.tiger.rbac.auth;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @Author Zenghu
 * @Date 2023年08月30日 21:15
 * @Description
 * @Version: 1.0
 **/
@Data
public class SysUserDetails implements UserDetails {
    private static final long serialVersionUID = -5526064253391755062L;
    private String username;
    @JSONField(serialize = false)
    private String password;
    private LocalDateTime loginTime;
    private Collection<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
