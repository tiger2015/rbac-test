package com.tiger.rbac.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.net.URL;

/**
 * @Author Zenghu
 * @Date 2023年09月02日 19:02
 * @Description
 * @Version: 1.0
 **/
@Configuration
@ConfigurationProperties(prefix = "cache")
@Data
@Slf4j
public class CacheConfig {
    private String config;

    @Bean(initMethod = "init", destroyMethod = "close")
    public CacheManager cacheManager() throws Exception {
        CachingProvider cachingProvider = Caching.getCachingProvider();
        URL resource;
        if (config.startsWith("classpath")) {
           resource = this.getClass().getResource(config.substring(config.indexOf(':') + 1));
        } else {
            resource = new URL(config);
        }
        // jsr107
        //return cachingProvider.getCacheManager(resource.toURI(),this.getClass().getClassLoader());
        return CacheManagerBuilder.newCacheManager(new XmlConfiguration(resource));
    }
}
