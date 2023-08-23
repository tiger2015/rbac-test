package com.tiger.rbac.common.exception;

/**
 * @Author Zenghu
 * @Date 2023年07月08日 12:07
 * @Description
 * @Version: 1.0
 **/
public class BaseException extends Throwable {

    public BaseException(String message){
        super(message);
    }

    public BaseException(String message, Throwable cause){
        super(message, cause);
    }
}
