package com.lalochen.springbootmall.service;

import com.lalochen.springbootmall.dto.UserRegisterRequest;
import com.lalochen.springbootmall.model.User;

public interface UserService {


    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);



}
