package com.example.service;

import com.example.pojo.User;

/**
 * @Author: Gyx
 * @Date: 2021/4/19 15:02
 */
public interface UserService {

    /**
     * 按ID查询用户信息
     * @param id
     * @return
     */
    User findById(Long id);
}

