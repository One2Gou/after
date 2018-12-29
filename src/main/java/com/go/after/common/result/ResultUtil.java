package com.go.after.common.result;

/**
 * @author: dong
 * @description:返回消息处理工具类,主要有成功和失败
 * @date: Create in 13:54 2018/12/28
 */
public class ResultUtil {

    /**
     * 返回成功信息
     *
     * @param data
     * @return
     */
    public static Result getSuccess(Object data) {
        Result result = new Result();
        //设置状态码
        result.setCode(200);
        //设置成功信息
        result.setMsg("操作成功!");
        //设置返回数据
        result.setData(data);
        return result;
    }

    /**
     * 重载Success方法 因为有时候不需要返回数据
     *
     * @return
     */
    public static Result getSuccess() {
        return getSuccess(null);
    }

    /**
     * 返回错误信息
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static Result getError(Integer code, String msg, Object data) {
        Result result = new Result();
        //设置错误状态码
        result.setCode(code);
        //设置错误信息
        result.setMsg(msg);
        //设置错误数据
        result.setData(data);
        return result;
    }

    /**
     * 错误方法重载 是因为有时候错误是不需要返回数据的
     *
     * @param code
     * @param msg
     * @return
     */
    public static Result getError(Integer code, String msg) {
        return getError(code, msg, null);
    }

}
