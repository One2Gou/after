package com.go.after.sys.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.go.after.common.utils.PageBean;
import com.go.after.common.utils.PageUtils;
import com.go.after.sys.mapper.UserMapper;
import com.go.after.sys.model.User;
import com.go.after.sys.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户服务实现类
 * </p>
 *
 * @author dong
 * @since 2018-12-25
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @DS(value = "slave_1")
    @Override
    public Page<User> listUser(Map<String, Object> args, PageBean pageBean) {
        //用户姓名 如果未传姓名
        final String userName = (String) args.get("userName") == null ? "" : ((String) args.get("userName")).trim();
        //查询条件
        final EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.like("user_name", userName);

        final Page<User> userPage = super.selectPage(new Page<>(pageBean.getPage(), pageBean.getRows()), entityWrapper);
        return userPage;
    }

    /**
     * 根据ID进行删除
     *
     * @param id
     * @return
     */
    @DS(value = "master")
    @Override
    public boolean deleteById(Serializable id) {
        final Integer integer = userMapper.deleteById(id);
        return com.go.after.common.utils.SqlHelper.cudBool(integer);
    }


    @DS(value = "slave_1")
    @Override
    public PageUtils listUserToRole(PageBean pageBean) {
        //设置页码和页大小
        final Page<Map<String, Object>> mapPage = new Page<>(pageBean.getPage(), pageBean.getRows());
        final List<Map<String, Object>> maps = userMapper.listUserToRole(mapPage);
        //设置数据
        mapPage.setRecords(maps);
        final PageUtils pageUtils = new PageUtils(mapPage.getRecords(), mapPage.getTotal());
        return pageUtils;
    }

    @Override
    public Integer addUser(User user) {
        final Integer insert = userMapper.insert(user);
        return insert;
    }


}
