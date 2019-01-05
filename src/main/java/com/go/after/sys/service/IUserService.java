package com.go.after.sys.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.go.after.common.utils.PageBean;
import com.go.after.common.utils.PageUtils;
import com.go.after.sys.model.User;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>
 * 用户服务类
 * </p>
 *
 * @author dong
 * @since 2018-12-25
 */
public interface IUserService extends IService<User> {

    /**
     * 用户查询分页+条件
     *
     * @param args
     * @param pageBean
     * @return
     */
    Page<User> listUser(Map<String, Object> args, PageBean pageBean);

    /**
     * 通过ID删除用户
     *
     * @param id
     * @return
     */
    @Override
    boolean deleteById(Serializable id);

    /**
     * 查询用于拥有的角色
     *
     * @param pageBean
     * @return
     */
    PageUtils listUserToRole(PageBean pageBean);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    Integer addUser(User user);

}
