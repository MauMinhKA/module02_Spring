package com.example.demoormcustomer.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameValidation.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FirstNameValid {
    String message() default "Invalid first name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}