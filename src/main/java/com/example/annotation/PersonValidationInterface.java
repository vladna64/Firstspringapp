package com.example.annotation;



import com.example.validator.PersonValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PersonValidator.class)
@Documented
public  @interface PersonValidationInterface {
    String message() default  "Invalid Person validation";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}