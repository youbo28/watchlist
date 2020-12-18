package com.openclassrooms.watchlist.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PriorityValidator.class)
public @interface Prioirity {
	String message() default "the priority need to be H,M or L";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
