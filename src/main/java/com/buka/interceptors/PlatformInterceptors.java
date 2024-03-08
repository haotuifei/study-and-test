package com.buka.interceptors;

import com.alibaba.fastjson.JSON;
import com.buka.pojo.Platform;
import com.buka.pojo.User;
import com.buka.util.ResponseJson;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PlatformInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        Platform platform = (Platform) httpSession.getAttribute("platform");
        if (platform == null){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(JSON.toJSONString(ResponseJson.getError(501,"未登录")));
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
