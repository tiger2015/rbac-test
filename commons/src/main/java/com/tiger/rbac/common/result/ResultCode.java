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
    UNAUTHORIZED(401, "Unauthorized"),
    BAD_PASSWORD(402, "bad password"),
    USER_NOT_FOUND(403, "user not found"),
    INVALID_TOKEN(404, "invalid token"),
    TOKEN_EXPIRED(405, "token expired"),
    SERVER_ERROR(500, "server error");
    public final int code;
    public final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
