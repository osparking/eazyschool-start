package com.eazybytes.eazyschool.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String displayLoginPage(Model model,
            @RequestParam(value="error", required = false) String error,
            @RequestParam(value="logout", required = false) String logout) {
        String errorMsg = null;
        if (error != null) {
            errorMsg = "유저네임 혹은 비밀번호 오류입니다.";
        }
        if (logout != null && "true".equals(logout)) {
            errorMsg = "성공적으로 로그아웃 되었습니다.";
        }
        model.addAttribute("errorMessge", errorMsg);
        return "login.html";
    }

}