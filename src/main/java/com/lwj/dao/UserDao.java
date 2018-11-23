package com.lwj.dao;

import com.lwj.pojo.User;

public interface UserDao {
    User selectById(long id);

    void insertUser(User user);

    void updateById(long id);
}
