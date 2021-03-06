package com.zys.springbootshiro.service;

import com.zys.springbootshiro.entity.User;

/**
 * @author zhongyushi
 * @date 2020/10/10 0010
 * @dec 描述
 */
public interface UserService {
    User getUserByName(String name);

    int createUser(User user);

    User getLoginUser();
}
