package com.buka.interceptors;

import com.alibaba.fastjson.JSON;
import com.buka.pojo.User;
import com.buka.util.ResponseJson;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        if (user == null){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(JSON.toJSONString(ResponseJson.getError(501,"未登录")));
            return false;
        } else if (user.getUserState() == 1){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(JSON.toJSONString(ResponseJson.getError(501,"账号已被封禁")));
            return false;
        } else {
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
