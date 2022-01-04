package com.xdemy.mobile_xdemy.mapper;

import com.xdemy.mobile_xdemy.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int createUser(User user);

    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd")String pwd);

    User findUserById(@Param("user_id") Integer userId);

//    User findByPhone(@Param("phone") String phone);

}
