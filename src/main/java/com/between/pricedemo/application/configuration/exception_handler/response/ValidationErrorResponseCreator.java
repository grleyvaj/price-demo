package com.between.pricedemo.application.configuration.exception_handler.response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

@RequiredArgsConstructor
@Slf4j
public class ValidationErrorResponseCreator {

	private final MessageSource messageSource;

	public ValidationErrorResponse create(String code) {
		try {
			return new ValidationErrorResponse(
				code,
				this.messageSource.getMessage(code, null, Locale.getDefault()),
				this.messageSource.getMessage(code.concat(".detail"), null, Locale.getDefault())
			);
		} catch(NoSuchMessageException ex) {
			log.error(ex.getMessage());
			return null;
		}
	}

}
