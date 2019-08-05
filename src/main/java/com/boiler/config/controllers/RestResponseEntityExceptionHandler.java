package com.boiler.config.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(value = { ConstraintViolationException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public MessageDTO handleBadInput(ConstraintViolationException ex) {

		Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();

		return processFieldError(violations);

	}

	@ExceptionHandler(value = { TransactionSystemException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public MessageDTO handleBadInput2(TransactionSystemException ex) {

		Throwable root = ExceptionUtils.getRootCause(ex);

		if (root instanceof ConstraintViolationException) {
			Set<ConstraintViolation<?>> violations = ((ConstraintViolationException) root).getConstraintViolations();
			return processFieldError(violations);
		} else {

			throw ex;

		}

	}

	private MessageDTO processFieldError(Set<ConstraintViolation<?>> violations) {
		MessageDTO message = new MessageDTO();
		List<FieldValidationResponse> items = new LinkedList<>();
		message.setMessagetype(MessageType.ERROR);
		//message.setMessage("Validation prolbem.");
		String pepe = violations.stream().findFirst().get().getMessageTemplate();
		message.setMessage(pepe);
		message.setItems(items);
		Locale currentLocale = LocaleContextHolder.getLocale();

		/*for (ConstraintViolation<?> constraintViolation : violations) {
			String template = constraintViolation.getMessageTemplate();
			String field = constraintViolation.getPropertyPath().toString();
			String msg = messageSource.getMessage(template, new Object[] { field }, currentLocale);
			FieldValidationResponse fvr = new FieldValidationResponse();
			fvr.setField(field);
			fvr.setMessage(msg);
			items.add(fvr);
		}*/

		return message;
	}

}
