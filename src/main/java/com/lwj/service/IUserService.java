package com.lwj.service;

import com.lwj.pojo.User;

public interface IUserService {
    User getUserById(long id);

    void insertUser(User user);

    void updateById(long id) throws Exception;
}
