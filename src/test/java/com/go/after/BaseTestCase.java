package com.go.after;

import com.go.after.common.utils.PageBean;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Create on 2018/9/22 on Dong
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTestCase {

    protected PageBean pageBean;

    @Before
    public void before() {
        pageBean = new PageBean();
    }

}
