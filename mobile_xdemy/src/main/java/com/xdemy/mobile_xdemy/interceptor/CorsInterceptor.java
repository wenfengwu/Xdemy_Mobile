package com.xdemy.mobile_xdemy.interceptor;

import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//cross-domain handler
public class CorsInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //Accept all http request
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));

        //check if it carries cookie, boolean
        response.setHeader("Access-Control-Allow-Credentials", "true");

        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS");

        response.setHeader("Access-Control-Allow-Headers", "*");

        //http options request while cross-domain
        if(HttpMethod.OPTIONS.toString().equals(request.getMethod())){
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
