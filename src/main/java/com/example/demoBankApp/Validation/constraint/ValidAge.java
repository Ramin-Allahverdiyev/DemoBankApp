package com.example.demoBankApp.Validation.constraint;

import com.example.demoBankApp.Validation.ErrorMessages;
import com.example.demoBankApp.Validation.validator.AgeConstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = AgeConstraintValidator.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface ValidAge {
    String message() default ErrorMessages.INVALID_AGE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
