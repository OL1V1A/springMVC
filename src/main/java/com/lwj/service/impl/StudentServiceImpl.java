package com.lwj.service.impl;

import com.lwj.dao.StudentDao;
import com.lwj.pojo.Student;
import com.lwj.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auth: lwj
 * @Date: 2019/4/11 13:36
 */
@Service("studentService")
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student selectById(int id) {
        return studentDao.selectById(id);
    }
}
