package com.github.mljr.aspect;

import com.github.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectOption {

    @Test
    public void testAnnotation() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-aspect.xml");
        UserDao dao = ac.getBean(UserDao.class);
        dao.run();
    }

    @Test
    public void test() throws Exception {
    }
}
