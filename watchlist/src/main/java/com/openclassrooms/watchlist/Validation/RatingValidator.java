package com.openclassrooms.watchlist.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RatingValidator implements ConstraintValidator<Rating, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		double number;
		try {
			number=Double.parseDouble(value);
		} catch (Exception e) {
			return false;
		}
		if (number <= 10 && number >=0) {
			return true;
		}
		return false;
	}

}
