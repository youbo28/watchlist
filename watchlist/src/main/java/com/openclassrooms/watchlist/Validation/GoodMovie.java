package com.openclassrooms.watchlist.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GoodMovieValidator.class)
public @interface GoodMovie {
	String message() default"if the rating is 8 or above the priority should be M or H";
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
