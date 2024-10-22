package com.lalochen.springbootmall.service.impl;

import com.lalochen.springbootmall.dao.UserDao;
import com.lalochen.springbootmall.dto.UserRegisterRequest;
import com.lalochen.springbootmall.model.User;
import com.lalochen.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }


}
