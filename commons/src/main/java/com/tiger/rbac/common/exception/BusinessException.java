package com.tiger.rbac.common.exception;

import com.tiger.rbac.common.result.ResultCode;

/**
 * @Author Zenghu
 * @Date 2023年07月08日 12:08
 * @Description
 * @Version: 1.0
 **/
public class BusinessException extends BaseException{
    public BusinessException(ResultCode code){
        super(code.message);
    }

    public BusinessException(ResultCode code, Throwable cause){
        super(code.message, cause);
    }

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(String message, Throwable cause){
        super(message, cause);
    }
}
