package com.matmazur.springsecurityboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

    @GetMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.put("message", "Hello Secure World!");
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
