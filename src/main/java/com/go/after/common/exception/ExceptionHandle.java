package com.go.after.common.exception;

import com.go.after.common.result.ResultEum;
import com.go.after.common.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: dong
 * @description:统一异常处理
 * @date: Create in 14:03 2018/12/28
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    /**
     * 设置错误级别
     */
    public static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 注:前后端分离情况下 不需要返回页面
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle(Exception e) {
        log.info("ExceptionHandle......handle()");
        //如果是自定义异常
        if (e instanceof MyException) {
            MyException myException = (MyException) e;
            return ResultUtil.getError(myException.getCode(), myException.getMessage());
        } else {//否则为系统异常
            log.error("系统异常={}", e);
            return ResultUtil.getError(ResultEum.SystemException.getCode(), ResultEum.SystemException.getMsg());
        }
    }


    /**
     * 判断是否为AJAX请求
     *
     * @param request
     * @return
     */
    public boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }

}
