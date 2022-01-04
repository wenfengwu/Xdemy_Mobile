package com.xdemy.mobile_xdemy.controller;

import com.xdemy.mobile_xdemy.model.entity.User;
import com.xdemy.mobile_xdemy.model.request.LoginRequest;
import com.xdemy.mobile_xdemy.service.UserService;
import com.xdemy.mobile_xdemy.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
//private route
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public JsonData register(@RequestBody Map<String, String> userInfo){

        int newOne = userService.createUser(userInfo);

        return newOne == 1 ? JsonData.bulidSuccess() : JsonData.bulidError("register failed, please try again");

    }

    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest){
        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());
        return token == null ? JsonData.bulidError("wrong information") : JsonData.bulidSuccess(token);
    }

    //find user info by user id
    @GetMapping("find_by_token")
    public JsonData findUserByToken(HttpServletRequest request){
        //get from login
        Integer userId = (Integer) request.getAttribute("user_id");
        if(userId == null){
            return JsonData.bulidError("request failed");
        }
        User user = userService.findUserById(userId);
        return JsonData.bulidSuccess(user);
    }
}
