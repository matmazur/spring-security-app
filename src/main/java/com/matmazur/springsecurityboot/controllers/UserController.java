package com.matmazur.springsecurityboot.controllers;

import com.matmazur.springsecurityboot.model.User;
import com.matmazur.springsecurityboot.repositories.UserRepository;
import com.matmazur.springsecurityboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final
    UserService userService;

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String registerForm(ModelMap modelMap) {

        modelMap.put("user", new User());
        return "register-form";
    }

    @PostMapping("/register")
    public String registerProcess(@Valid @ModelAttribute User user, BindingResult result, ModelMap modelMap) {

        if (userRepository.findByEmail(user.getEmail()) != null) {
            result.addError(new ObjectError("Email duplicate", "This email address already exists in database"));
        }
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            errors.forEach(System.err::println);
            modelMap.put("errors", errors);
            return "register-form";
        }
        if (user.getEmail().equals("matmazur90@gmail.com")) {
            userService.addWithAdminPriviliges(user);
        } else {
            userService.addWithDefaultRole(user);
        }
        modelMap.put("registered", "registration successful");
        modelMap.put("user", new User());
        return "index";
    }
}
