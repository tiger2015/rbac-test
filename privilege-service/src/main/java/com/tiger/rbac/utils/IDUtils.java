package com.tiger.rbac.utils;

import java.util.UUID;

/**
 * @Author Zenghu
 * @Date 2023年10月12日 23:13
 * @Description
 * @Version: 1.0
 **/
public class IDUtils {

    public static String id() {
        return UUID.randomUUID().toString();
    }
}
