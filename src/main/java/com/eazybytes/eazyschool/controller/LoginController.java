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
            @RequestParam(value="error", required = false) String error) {
        String errorMsg = null;
        if (error != null) {
            errorMsg = "유저네임 혹은 비밀번호 오류입니다.";
        }
        model.addAttribute("errorMessge", errorMsg);
        return "login.html";
    }

}