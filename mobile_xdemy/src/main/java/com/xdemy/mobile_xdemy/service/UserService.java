package com.xdemy.mobile_xdemy.service;

import com.xdemy.mobile_xdemy.model.entity.User;

import java.util.Map;

public interface UserService {

    int createUser(Map<String, String> userIfo);

    String findByPhoneAndPwd(String phone, String pwd);

    User findUserById(Integer userId);

//    User findByPhone(String phone);
}
