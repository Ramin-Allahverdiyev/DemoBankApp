package com.example.demoBankApp.Validation.validator;

import com.example.demoBankApp.Validation.constraint.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.passay.*;

import java.util.Arrays;
import java.util.List;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
//        PasswordValidator validator = new PasswordValidator(Arrays.asList(
//                new LengthRule(8, 30),
//                new UppercaseCharacterRule(1),
//                new DigitCharacterRule(1),
//                new WhitespaceRule()));
//
//        RuleResult result = validator.validate(new PasswordData(password));
//        if (result.isValid()) {
//            return true;
//        }
//        List<String> messages = validator.getMessages(result);
//        String messageTemplate = String.join(",", messages);
//        context.disableDefaultConstraintViolation();
//        context.buildConstraintViolationWithTemplate(messageTemplate)
//                .addConstraintViolation();
//        return false;

    }
}
