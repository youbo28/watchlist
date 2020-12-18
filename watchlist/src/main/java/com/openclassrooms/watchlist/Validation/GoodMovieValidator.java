package com.openclassrooms.watchlist.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.openclassrooms.watchlist.Domain.WatchlistItem;

public class GoodMovieValidator implements ConstraintValidator<GoodMovie, WatchlistItem> {

	@Override
	public boolean isValid(WatchlistItem value, ConstraintValidatorContext context) {

		return !(Double.valueOf(value.getRating()) >= 8 && "L".contains(value.getPriority().toUpperCase()));
	}

}
