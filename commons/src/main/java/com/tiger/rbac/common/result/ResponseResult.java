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

    private ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
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

    public static ResponseResult<Void> success() {
        ResponseResult<Void> result = new ResponseResult<>(ResultCode.SUCCESS);
        return result;
    }

    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> result = new ResponseResult<>(ResultCode.SUCCESS);
        result.data = data;
        return result;
    }

    public static ResponseResult<Void> error(int code, String message) {
        return new ResponseResult<>(code, message);
    }

    public static ResponseResult<Void> error(ResultCode code) {
        return new ResponseResult<>(code);
    }
}
