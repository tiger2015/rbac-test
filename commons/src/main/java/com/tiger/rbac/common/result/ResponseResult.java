package com.tiger.rbac.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @Author Zenghu
 * @Date 2023年07月08日 11:55
 * @Description
 * @Version: 1.0
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -7842600748973544978L;
    private int code;
    private String message;
    private T data;

    private ResponseResult(ResultCode resultCode) {
        this.code = resultCode.code;
        this.message = resultCode.message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static ResponseResult success(ResultCode code) {
        ResponseResult result = new ResponseResult(code);
        return result;
    }

    public static <T> ResponseResult success(ResultCode code, T data) {
        ResponseResult result = new ResponseResult(code);
        result.data = data;
        return result;
    }

    public static ResponseResult error(ResultCode code) {
        ResponseResult result = new ResponseResult(code);
        return result;
    }
}
