package com.go.after.sys.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.go.after.common.result.Result;
import com.go.after.common.result.ResultUtil;
import com.go.after.common.utils.ApolloUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dong
 * @description:测试Apollo 分布式配置中心
 * @date: Create in 12:23 2019/1/4
 */

@RestController
@Api(value = "测试Apollo分布式配置中心")
@RequestMapping(value = {"/apollo/"})
@Slf4j
public class ApolloController {

    /**
     * 自动注入
     * 底层原理:通过ConfigService.getConfig(namespace),再通过Manager反射实例化出对象
     */
    @ApolloConfig(value = "TEST1.application-prd")
    private Config prdConfig;

    @Value(value = "${eleya.name}")
    private String name;


    @ApiOperation(value = "从Apollo分布式配置中心读取文件-Application.properties")
    @GetMapping(value = {"helloApollo"})
    public Result helloApollo() {
        return ResultUtil.getSuccess(name);
    }

    @ApiOperation(value = "读取Application-prd.properties")
    @GetMapping(value = {"helloApollo2"})
    public Result helloApollo2() {
        final String prdName = ApolloUtil.getKeyToValue(prdConfig, "prd.name");
        return ResultUtil.getSuccess(prdName);
    }

}
