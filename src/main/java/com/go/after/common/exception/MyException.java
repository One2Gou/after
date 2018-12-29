package com.go.after.common.exception;

import lombok.Data;

/**
 * @author: dong
 * @description: 自定义异常信息
 * @date: Create in 13:36 2018/12/28
 */
@Data
public class MyException extends RuntimeException {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 定义错误信息
     *
     * @param message
     */
    public MyException(String message) {
        super(message);
    }

    /**
     * 定义错误信息以及状态码
     *
     * @param message
     * @param code
     */
    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
