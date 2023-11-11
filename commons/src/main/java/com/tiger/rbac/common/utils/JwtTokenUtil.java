package com.tiger.rbac.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Map;

/**
 * @Author Zenghu
 * @Date 2023年08月30日 21:41
 * @Description
 * @Version: 1.0
 **/
public class JwtTokenUtil {

    /**
     * 生成token
     *
     * @param secret
     * @param claims
     * @return
     */
    public static String genToken(String secret, Map<String, Object> claims) {
        JWTCreator.Builder claimBuilder = JWT.create();
        if (!CollectionUtils.isEmpty(claims)) {
            claims.forEach((s, o) -> claimBuilder.withClaim(s, String.valueOf(o)));
        }
        return claimBuilder.sign(Algorithm.HMAC256(secret));
    }


    /**
     * 带有过期时间
     *
     * @param secret
     * @param expireInSeconds
     * @param claims
     * @return
     */
    public static String genToken(String secret, long expireInSeconds, Map<String, Object> claims) {
        JWTCreator.Builder claimBuilder = JWT.create();
        if (!CollectionUtils.isEmpty(claims)) {
            claims.forEach((s, o) -> claimBuilder.withClaim(s, String.valueOf(o)));
        }
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expireTime = now.plusSeconds(expireInSeconds);
        claimBuilder.withIssuedAt(Date.from(now.atZone(ZoneOffset.systemDefault()).toInstant()));
        claimBuilder.withExpiresAt(Date.from(expireTime.atZone(ZoneOffset.systemDefault()).toInstant()));
        return claimBuilder.sign(Algorithm.HMAC256(secret));
    }


    /**
     * token验证
     *
     * @param secret
     * @param token
     * @return
     */
    public static boolean verifyToken(String secret, String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
        jwtVerifier.verify(token);
        return true;
    }


    /**
     * 从token中取出指定名称
     *
     * @param secret
     * @param token
     * @return
     */
    public static String getClaim(String secret, String token, String name) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
        DecodedJWT verify = jwtVerifier.verify(token);
        return verify.getClaim(name).asString();
    }

}
