package com.xdemy.mobile_xdemy;

import com.xdemy.mobile_xdemy.model.entity.User;
import com.xdemy.mobile_xdemy.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class MobileXdemyApplicationTests {

	@Test
	public void testToken(){
		User user = new User();
		user.setId(66);
		user.setName("daxiaxia");
		user.setHeadImg("png");

		String token = JWTUtils.jsonWebToken(user);

		System.out.println(token);

		Claims claims =  JWTUtils.checkJWT(token);

		System.out.println(claims.get("name"));
	}


}
