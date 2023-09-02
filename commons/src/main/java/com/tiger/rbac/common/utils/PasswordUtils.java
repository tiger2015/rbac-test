package com.tiger.rbac.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author Zenghu
 * @Date 2023年08月28日 21:22
 * @Description
 * @Version: 1.0
 **/
public class PasswordUtils {
    public static String encode(String password, String salt) throws NoSuchAlgorithmException {
        String input = password + salt;
        DigestUtils digestUtils = new DigestUtils(MessageDigest.getInstance("SHA-256"));
        return digestUtils.digestAsHex(input.getBytes(StandardCharsets.UTF_8));
    }

}
