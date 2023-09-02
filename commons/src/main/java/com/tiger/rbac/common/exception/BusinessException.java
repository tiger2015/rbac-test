package com.tiger.rbac.common.exception;

import com.tiger.rbac.common.result.ResultCode;
import lombok.Getter;

/**
 * @Author Zenghu
 * @Date 2023年07月08日 12:08
 * @Description
 * @Version: 1.0
 **/
public class BusinessException extends BaseException {
    @Getter
    private int code;

    public BusinessException(ResultCode code) {
        super(code.message);
        this.code = code.code;
    }

    public BusinessException(ResultCode code, Throwable cause) {
        super(code.message, cause);
        this.code = code.code;
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
