package com.xdemy.mobile_xdemy.service.impl;

import com.xdemy.mobile_xdemy.mapper.UserMapper;
import com.xdemy.mobile_xdemy.model.entity.User;
import com.xdemy.mobile_xdemy.service.UserService;
import com.xdemy.mobile_xdemy.utils.JWTUtils;
import com.xdemy.mobile_xdemy.utils.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int createUser(Map<String, String> userInfo) {
        User user = parseToUser(userInfo);
        if(user != null){
            return userMapper.createUser(user);
        }
        else{
            return -1;
        }
    }

    //login and pass token
    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        User user = userMapper.findByPhoneAndPwd(phone, UtilTools.MD5(pwd));
        if(user == null){
            return null;
        }
        else{
            String token = JWTUtils.jsonWebToken(user);
            return token;
        }
    }

    @Override
    public User findUserById(Integer userId) {
        User user = userMapper.findUserById(userId);
        //clean up password for privacy, even though pwd has been encrypted, Or add @JsonIgnore on User model
        //user.setPwd("");
        return user;
    }

    private User parseToUser(Map<String, String> userInfo){
        if(userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")){
            User user = new User();
            user.setName(userInfo.get("name"));
            user.setHeadImg(randomImg());
            user.setPhone(userInfo.get("phone"));
            user.setCreateTime(new Date());
            String password = userInfo.get("pwd");
            user.setPwd(UtilTools.MD5(password));
            return user;
        }
        else{
            return null;
        }
    }

    //random avatar
    private static final String [] headImg = {
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSq_ByyjQba49fhvwfDZ-haECcd6_tVOLt5VlEvCNWbPrxwBlwEsh5ykTDIAyI8spgAtyE&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTuiAuuVcoQ8xR3aR_Iau3vBn2kVZvXAM58A40u_xYw1FI3VjcOKlayEV1YTjvj7M_8usc&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxtf3W5HqrAJ2bVJQANO2tTOoWYrAIReuFzg&usqp=CAU",
            "https://static.wikia.nocookie.net/crayonshinchan/images/5/5e/Ai.jpg/revision/latest?cb=20110120192554",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRN0OqXLdI-WBPRV-uG4uEqiYa59Oz4UTKRkA&usqp=CAU"
    };

    private String randomImg(){
        int size = headImg.length;
        Random random = new Random();
        int imgIndex = random.nextInt(size);
        return headImg[imgIndex];
    }


}
