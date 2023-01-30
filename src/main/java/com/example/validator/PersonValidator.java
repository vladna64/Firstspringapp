package com.example.validator;

import com.example.ValidatingforminputApplication;
import com.example.annotation.PersonValidationInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonValidator  implements ConstraintValidator<PersonValidationInterface, String> {
    private static final Logger log = LoggerFactory.getLogger(ValidatingforminputApplication.class);

    @Override
    public void initialize(PersonValidationInterface validationInterface) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context)
    {
        Pattern pattern = Pattern.compile("^[а-яА-ЯёЁa-zA-Z]+$");
        Matcher matcher = pattern.matcher(value);
        log.debug("validationInterface");
        log.debug("Matcher:", matcher);
        try {
            if (!matcher.matches()) {

                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }


}
