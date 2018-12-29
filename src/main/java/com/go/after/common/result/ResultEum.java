package com.go.after.common.result;

/**
 * @author: dong
 * @description:自定义一些返回状态码
 * @date: Create in 13:47 2018/12/28
 */
public enum ResultEum {

    /**
     * 成功：HTTP成功状态码
     */
    SUCCESS(200, "成功"),

    /**
     * 系统异常：-1
     */
    SystemException(-1, "系统异常"),

    /**
     * 未知异常:01
     */
    UnknownException(01, "未知异常"),

    /**
     * 服务异常:02
     */
    ServiceException(02, "服务异常"),

    /**
     * 业务错误:03
     */
    MyException(03, "业务错误"),

    /**
     * 提示级错误：04
     */
    InfoException(04, "提示级错误"),

    /**
     * 数据库异常:05
     */
    DBException(05, "数据库异常"),

    /**
     * 参数验证错误:06
     */
    ParamException(06, "参数验证错误");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String msg;

    ResultEum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
