package com.panda.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SignupInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {

        String emailAddress = request.getParameter("emailaddress");
        String password = request.getParameter("password");

        if (StringUtils.isEmpty(emailAddress) ||
                StringUtils.containsWhitespace(emailAddress) ||
                StringUtils.isEmpty(password) ||
                StringUtils.containsWhitespace(password)) {
            throw new Exception("Invalid Email Address or Password. Please try again.");
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response,
            Object handler, Exception exception)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object handler, ModelAndView modelAndView)
            throws Exception {
    }
}
