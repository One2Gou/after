package com.go.after.base.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Create on 2018/10/11 on Dong
 *
 * @author dong
 * 用于放置一些公共的配置
 */
@Controller
@Slf4j
@Getter
@Setter
public abstract class BaseController implements Serializable {

    private static final long serialVersionUID = 8961654111010922556L;

    /**
     * 消息
     */
    protected Map<String, Object> message;

    /**
     * 将数据转换为Json
     */
    protected Map<String, Object> jsonData;

    /**
     * 前端跳转页面
     */
    protected Map<String, Object> fronData;


    /**
     * 初始化message，jsonData，fronData
     *
     * @param request
     * @param response
     * @param model
     */
    @ModelAttribute
    public void initController(HttpServletRequest request, HttpServletResponse response, Model model) {
        message = new HashMap<String, Object>(10);
        jsonData = new HashMap<String, Object>(10);
        fronData = new HashMap<String, Object>(10);
        log.info("BaseController....initController()");
    }

}
