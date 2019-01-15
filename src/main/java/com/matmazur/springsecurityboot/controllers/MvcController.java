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
    public String secret(ModelMap modelMap) {
        modelMap.put("message", "Hello Secure World!");
        return "admin-page";
    }
}
