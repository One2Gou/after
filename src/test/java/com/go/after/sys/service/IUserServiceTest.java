package com.go.after.sys.service;

import com.go.after.BaseTestCase;
import com.go.after.common.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: dong
 * @description:
 * @date: Create in 16:31 2018/12/28
 */
@Slf4j
public class IUserServiceTest extends BaseTestCase {

    @Autowired
    private IUserService userService;

    @Override
    public void before() {
        super.before();
    }

    @Test
    public void listUserToRole() {
        final PageUtils pageUtils = userService.listUserToRole(pageBean);
        System.out.println(pageUtils);
//        final Page<Map<String, Object>> mapPage = userService.listUserToRole(new Page(pageBean.getPage(), pageBean.getRows()));
//
//        final Map<String, Object> condition = mapPage.getCondition();
//        condition.forEach((key,value)->{
//            log.info("key:{},value:{}", key, value);
//        });


    }
}