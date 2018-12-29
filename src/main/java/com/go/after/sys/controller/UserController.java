package com.go.after.sys.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.go.after.base.controller.BaseController;
import com.go.after.common.exception.MyException;
import com.go.after.common.result.Result;
import com.go.after.common.result.ResultUtil;
import com.go.after.common.utils.PageBean;
import com.go.after.common.utils.PageUtils;
import com.go.after.sys.model.User;
import com.go.after.sys.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dong
 * @since 2018-12-25
 */
@RestController
@RequestMapping("/sys/user")
@Api(value = "用户的CURD", tags = "处理用户Controller！")
@Slf4j
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;


    @PostMapping(value = {"/addUser"})
    @ApiOperation(value = "用户的添加接口")
    public Result addUser(@RequestBody @ApiParam(value = "User类型", name = "user") User user) {
        final boolean insert = userService.insert(user);
        if (insert) {
            return ResultUtil.getSuccess(null);
        } else {
            throw new MyException(-1, "添加用户失败!");
        }
    }

    @PostMapping(value = {"/listUser"})
    @ApiOperation(value = "查询用户集合分页")
    public PageUtils listUser(@RequestBody @ApiParam(value = "通过Map接收参数") Map<String, Object> args, @ApiParam(value = "通过PageBean进行分页/翻页/页行数") PageBean pageBean) {
        final Page<User> userPage = userService.listUser(args, pageBean);
        log.info("Total:{}", userPage.getTotal());
        return new PageUtils(userPage.getRecords(), userPage.getTotal());
    }


    @PostMapping(value = {"/delUser"})
    @ApiOperation(value = "删除用户!")
    public Result delUser(@RequestBody @ApiParam(value = "通过用户ID进行删除", name = "user") User user) {
        //通过ID进行删除
        final boolean isUser = userService.deleteById(user.getUserId());
        if (isUser) {
            return ResultUtil.getSuccess(null);
        } else {
            throw new MyException(-1, " 删除用户失败,该用户可能已经不存在!");
        }
    }

    @PostMapping(value = {"/listUserToRole"})
    @ApiOperation(value = "查询所有用户的角色")
    public PageUtils listUserToRole(@ApiParam(value = "通过PageBean进行分页/翻页") PageBean pageBean) {
        final PageUtils listUserToRole = userService.listUserToRole(pageBean);
        return listUserToRole;
    }

}
