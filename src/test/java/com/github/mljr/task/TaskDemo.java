package com.github.mljr.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-task.xml")
public class TaskDemo {

    @Test
    public void testSpringTask() throws Exception {
        System.in.read();
    }
}
