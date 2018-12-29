package com.go.after.sys.controller;


import com.go.after.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dong
 * @since 2018-12-28
 */
@RestController
@RequestMapping("/sys/role")
@Api(value = "角色处理控制器")
public class RoleController {

    @GetMapping(value = {"/role"})
    @ApiOperation(value = "角色欢迎页面")
    public Result role() {
        return new Result(0, "RoleController加载成功!");
    }

}
