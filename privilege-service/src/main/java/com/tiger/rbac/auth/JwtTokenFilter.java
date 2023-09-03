package com.tiger.rbac.auth;

import com.tiger.rbac.cache.AuthenticationCache;
import com.tiger.rbac.common.utils.JwtTokenUtil;
import com.tiger.rbac.config.AuthConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Zenghu
 * @Date 2023年09月01日 23:30
 * @Description
 * @Version: 1.0
 **/
@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    public static final String HEADER_TOKEN = "token";

    @Autowired
    private AuthConfig authConfig;

    @Autowired
    private AuthenticationCache cache;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HEADER_TOKEN);
        if (!StringUtils.hasLength(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        String username = JwtTokenUtil.getUsername(authConfig.getTokenSecret(), token);
        // 从缓存中获取授权信息
        SecurityContext context = SecurityContextHolder.getContext();
        if (context.getAuthentication() == null) {
            Authentication authentication = cache.get(username);
            context.setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
