package org.example.taskmaster.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // 去登录页
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // 处理登录请求（硬编码一个假账号 admin / 123456）
    @PostMapping("/doLogin")
    public String doLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
        if ("admin".equals(username) && "123456".equals(password)) {
            session.setAttribute("user", username); // 登录成功，存入 Session
            return "redirect:/"; // 跳回首页
        }
        return "redirect:/login?error"; // 失败，返回登录页带上错误参数
    }
}