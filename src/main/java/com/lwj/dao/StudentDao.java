package com.lwj.dao;

import com.lwj.pojo.Student;

/**
 * @Auth: lwj
 * @Date: 2019/4/11 13:31
 */
public interface StudentDao {

    Student selectById(int id);
}
