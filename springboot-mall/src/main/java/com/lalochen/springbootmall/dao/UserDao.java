package com.lalochen.springbootmall.dao;

import com.lalochen.springbootmall.dto.UserRegisterRequest;
import com.lalochen.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);

}
