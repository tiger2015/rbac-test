package com.tiger.rbac.controller;

import com.tiger.rbac.auth.AuthenticationResult;
import com.tiger.rbac.auth.LoginInfo;
import com.tiger.rbac.cache.AuthenticationCache;
import com.tiger.rbac.common.exception.BusinessException;
import com.tiger.rbac.common.result.ResponseResult;
import com.tiger.rbac.common.result.ResultCode;
import com.tiger.rbac.common.utils.JwtTokenUtil;
import com.tiger.rbac.common.utils.PasswordUtils;
import com.tiger.rbac.common.utils.RSAUtils;
import com.tiger.rbac.config.AuthConfig;
import com.tiger.rbac.model.po.SysUser;
import com.tiger.rbac.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Zenghu
 * @Date 2023年08月30日 21:20
 * @Description
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/")
@Slf4j
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthConfig authConfig;

    @Autowired
    private AuthenticationCache cache;

    @PostMapping("/login")
    public ResponseResult<AuthenticationResult> login(LoginInfo loginInfo) throws BusinessException {
        try {
            // 验证码验证

            // 首先将密码用私钥解密
            // 传递的密码是通过公钥加密后的
            String decryptedPassword = RSAUtils.decryptByPrivateKey(authConfig.getPrivateKey(), loginInfo.getPassword());
            // 查询用户
            SysUser sysUser = sysUserService.selectByName(loginInfo.getUsername());
            if (ObjectUtils.isEmpty(sysUser)) {
                throw new BusinessException(ResultCode.USER_NOT_FOUND);
            }
            // 通过salt对密码编码
            String encodePassword = PasswordUtils.encode(decryptedPassword, sysUser.getSalt());
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginInfo.getUsername(), encodePassword);
            // 认证
            Authentication authenticate = authenticationManager.authenticate(authenticationToken);
            // 生成token
            Map<String, Object> claims = new HashMap<>();
            claims.put("user", loginInfo.getUsername());
            String token = JwtTokenUtil.genToken(authConfig.getTokenSecret(), authConfig.getTokenValidTime(), claims);
            AuthenticationResult result = new AuthenticationResult();
            result.setToken(token);
            // 缓存
            cache.put(loginInfo.getUsername(), authenticate);
            return ResponseResult.success(result);
        } catch (AuthenticationException | BadPaddingException e) {
            throw new BusinessException(ResultCode.BAD_PASSWORD, e);
        } catch (Exception e) {
            throw new BusinessException(ResultCode.UNAUTHORIZED, e);
        }
    }
}
