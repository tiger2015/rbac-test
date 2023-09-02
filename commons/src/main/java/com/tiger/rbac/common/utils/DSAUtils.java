package com.tiger.rbac.common.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * @Author Zenghu
 * @Date 2023年08月31日 22:05
 * @Description
 * @Version: 1.0
 **/
public class DSAUtils {
    public static final String ALGORITHM_NAME = "DSA";
    public static final int KEY_SIZE = 64;

    public static String[] genKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM_NAME);
        keyPairGenerator.initialize(1024); // 设置密钥长度
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        return new String[]{Base64.encodeBase64String(keyPair.getPrivate().getEncoded()), Base64.encodeBase64String(keyPair.getPublic().getEncoded())};
    }




}
