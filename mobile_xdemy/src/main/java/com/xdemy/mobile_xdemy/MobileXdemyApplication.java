package com.xdemy.mobile_xdemy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//set the path of scanning mapper
@MapperScan("com.xdemy.mobile_xdemy.mapper")
@EnableTransactionManagement
public class MobileXdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileXdemyApplication.class, args);
	}

}
