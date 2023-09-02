package com.tiger.rbac.common.controller;

import com.tiger.rbac.common.exception.BusinessException;
import com.tiger.rbac.common.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author Zenghu
 * @Date 2023年09月01日 21:59
 * @Description
 * @Version: 1.0
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionController {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseResult<Void> businessException(BusinessException exception) {
        log.error(exception.getMessage(), exception);
        return ResponseResult.error(exception.getCode(), exception.getMessage());
    }

}
