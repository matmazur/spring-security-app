package com.matmazur.springsecurityboot.customValidators.validators;

import com.matmazur.springsecurityboot.customValidators.UniqueEmail;
import com.matmazur.springsecurityboot.model.User;
import com.matmazur.springsecurityboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        //tutaj wyciągamy informacje z adnotacji, np. wartości min/max
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        System.out.println(userRepository + " repository");

        System.out.println(s+ " string");
        System.out.println();
        System.out.println(userRepository.findByEmail(s));


        return true;
    }
}
