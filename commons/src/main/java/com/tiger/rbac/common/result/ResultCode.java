package com.tiger.rbac.common.result;

/**
 * @Author Zenghu
 * @Date 2023年07月08日 11:55
 * @Description
 * @Version: 1.0
 **/
public enum ResultCode {
    SUCCESS(200, "success"),
    FAIL(400, "fail"),
    RESOURCE_NOT_FOUND(500, "resource not found")
    ;
    public final int code;
    public final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
