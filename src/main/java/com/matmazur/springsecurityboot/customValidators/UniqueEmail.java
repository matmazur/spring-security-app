package com.matmazur.springsecurityboot.customValidators;

import com.matmazur.springsecurityboot.customValidators.validators.UniqueEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = {UniqueEmailValidator.class})
@Target({FIELD,CONSTRUCTOR,METHOD,ANNOTATION_TYPE,PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "Email should be unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
