package com.tiger.rbac.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @Author Zenghu
 * @Date 2023年09月02日 19:42
 * @Description
 * @Version: 1.0
 **/
@Slf4j
@Component
public class AuthenticationCache {


//    @Autowired
//    private CacheManager cacheManager;
//
//    private Cache<String, Authentication> authenticationCache;
//
//    @PostConstruct
//    public void init() {
//        authenticationCache = cacheManager.getCache("authenticationCache", String.class, Authentication.class);
//    }


    private final RedisCache<String, Object> redisCache;


    public AuthenticationCache(RedisCache<String, Object> redisCache) {
        this.redisCache = redisCache;
    }

    public void put(String key, Authentication value) {
        redisCache.set(key, value);
    }

    public Authentication get(String key) {
        return redisCache.get(key);
    }

    public void remove(String key) {
        redisCache.remove(key);
    }

    public void clear() {
        redisCache.clear();
    }
}
