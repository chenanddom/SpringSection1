package com.flexible.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-10-13
 * Time: 12:15
 */
/**
 * 使用TestNG测试
 */
@ContextConfiguration("classpath*:/flexible-context.xml")
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    UserService userService;
    @Test
    public void testHasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "1111");
        assertTrue(b1);
        assertTrue(!b2);
    }
}
