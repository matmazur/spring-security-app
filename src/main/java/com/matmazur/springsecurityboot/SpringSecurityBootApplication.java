package com.matmazur.springsecurityboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@SpringBootApplication
public class SpringSecurityBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityBootApplication.class, args);

    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}

