package com.go.after.common.result;

import lombok.Data;

/**
 * @author: dong
 * @description:异常处理实体包装类，自己用泛型进行写，扩展性行强
 * @date: Create in 13:43 2018/12/28
 */
@Data
public class Result<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    public Result() {
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
