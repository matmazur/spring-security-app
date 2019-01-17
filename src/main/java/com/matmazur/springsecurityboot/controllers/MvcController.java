package com.matmazur.springsecurityboot.controllers;

import com.matmazur.springsecurityboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MvcController {

    @GetMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.put("message", "Hello Secure World!");
        return "index";
    }

    @GetMapping("/register")
    public String registerForm(ModelMap modelMap) {

        modelMap.put("user", new User());
        return "register-form";
    }

    @PostMapping("/register")
    public String registerProcess(ModelMap modelMap) {

        modelMap.put("registered","registration successful");
        modelMap.put("user", new User());
        return "index";
    }


    @GetMapping("/admin-page")
    public String adminPage(ModelMap modelMap) {
        return "admin-page";
    }

    @GetMapping("/user-page")
    public String userPage(ModelMap modelMap) {
        return "user-page";
    }

    @GetMapping("/access-denied")
    public String accessDenied(ModelMap modelMap) {
        return "access-denied";
    }
}
