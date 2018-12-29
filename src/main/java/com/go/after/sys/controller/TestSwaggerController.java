package com.go.after.sys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Create on 2018/12/23 on Dong
 *
 * @author dong
 */
@RestController
@RequestMapping(value = {"/sys/test/"})
@Api(value = "测试SwaggerController", tags = "测试Swagger呀！")
@Slf4j
public class TestSwaggerController {

    /**
     * 通过
     *
     * @param args
     * @return
     */
    @PostMapping(value = {"test1"})
    @ApiOperation(value = "测试Swagger")
    public Map<String, Object> test1(@ApiParam(name = "args", value = "Map类型参数", required = true) @RequestBody Map<String, Object> args) {
        return args;
    }

}
