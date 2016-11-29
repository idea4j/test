package com.github.service;

import com.github.annotation.Cache;

@Cache(names = "Class cache")
public class UserServiceImpl {

    @Cache(names = "method cache")
    public void run() {
        System.out.println("userServiceImpl");
    }

}
