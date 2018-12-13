package com.lwj.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lwj.dao.UserDao;
import com.lwj.pojo.User;
import com.lwj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.json.Json;
import javax.servlet.jsp.tagext.TryCatchFinally;


@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;


    public User getUserById(long id) {
        User user = userDao.selectById(id);
        return user;

    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Transactional(value = "transactionManager")
    public void updateById(long id) throws Exception {
            userDao.updateById(id);
//        try{
//            int c = 1/0;
//        }catch(Exception e){
//            e.printStackTrace();
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        }
    }
}
