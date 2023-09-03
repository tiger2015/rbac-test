package com.tiger.rbac.cache;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author Zenghu
 * @Date 2023年09月02日 19:42
 * @Description
 * @Version: 1.0
 **/
@Slf4j
@Component
public class AuthenticationCache {


    @Autowired
    private CacheManager cacheManager;

    private Cache<String, Authentication> authenticationCache;

    @PostConstruct
    public void init() {
        authenticationCache = cacheManager.getCache("authenticationCache", String.class, Authentication.class);
    }

    public void put(String key, Authentication value) {
        authenticationCache.put(key, value);
    }

    public Authentication get(String key) {
        return authenticationCache.get(key);
    }

    public void remove(String key) {
        authenticationCache.remove(key);
    }

    public void clear() {
        authenticationCache.clear();
    }
}
