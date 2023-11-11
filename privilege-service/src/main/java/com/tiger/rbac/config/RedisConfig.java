package com.tiger.rbac.config;

import com.alibaba.fastjson.parser.ParserConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author Zenghu
 * @Date 2023年11月06日 21:15
 * @Description
 * @Version: 1.0
 **/
@Configuration
public class RedisConfig {

    @Bean("fastJsonRedisTemplate")
    public RedisTemplate<String, Object> fastJsonRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setHashKeySerializer(keySerializer);
        ParserConfig.getGlobalInstance().setAsmEnable(true);
        // 指定白名单
       // ParserConfig.getGlobalInstance().addAccept("com.tiger.rbac.");
      //  ParserConfig.getGlobalInstance().addAccept("org.springframework.security.authentication.");
       // ParserConfig.getGlobalInstance().addAccept("org.springframework.security.authentication.UsernamePasswordAuthenticationToken");
       // ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        FastJsonRedisSerializer<Object> valueSerializer = new FastJsonRedisSerializer<>(Object.class);
        redisTemplate.setValueSerializer(valueSerializer);
        redisTemplate.setHashValueSerializer(valueSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
