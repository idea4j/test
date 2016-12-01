package com.github.dao;

import com.github.annotation.Cache;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Cache
    public void run() {
        System.out.println("UserDao的run方法执行了...");
    }
}
