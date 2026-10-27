package org.example.taskmaster.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        // 检查 session 中是否有 "user"（代表已登录）
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login"); // 没登录，跳转登录页
            return false;
        }
        return true; // 已登录，放行
    }
}