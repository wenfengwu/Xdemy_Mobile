package com.xdemy.mobile_xdemy.config;

import com.xdemy.mobile_xdemy.interceptor.CorsInterceptor;
import com.xdemy.mobile_xdemy.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * interceptor settings
 * public route: api/v1/pub
 * private route: api/v1/pri
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    @Bean
    CorsInterceptor corsInterceptor(){
        return new CorsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //Intercept all routes
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");

        //Intercept routes: /api/v1/pri/**
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")
                //except route: /api/v1/pri/user/login, /api/v1/pri/user/register
                .excludePathPatterns("/api/v1/pri/user/login", "/api/v1/pri/user/register");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
