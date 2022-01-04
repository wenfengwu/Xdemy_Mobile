package com.xdemy.mobile_xdemy.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xdemy.mobile_xdemy.utils.JWTUtils;
import com.xdemy.mobile_xdemy.utils.JsonData;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    //the method before entering in controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            String accessToken = request.getHeader("token");
            if (accessToken == null) {
                accessToken = request.getParameter("token");
            }

            if (StringUtils.isNotBlank(accessToken)) {
                Claims claims = JWTUtils.checkJWT(accessToken);
                //login failed
                if (claims == null) {
                    sendJsonMessage(response, JsonData.bulidError("verify failed, please login in again"));
                    return false;
                }
                Integer id = (Integer) claims.get("id");
                String name = (String) claims.get("name");

                request.setAttribute("user_id", id);
                request.setAttribute("name", name);
                return true;
            }
        }
        catch(Exception e){}
        //login failed
        return false;
    }

    //response Json info to frontend
    public static void sendJsonMessage(HttpServletResponse response, Object obj){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(objectMapper.writeValueAsString(obj));
            writer.close();
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
