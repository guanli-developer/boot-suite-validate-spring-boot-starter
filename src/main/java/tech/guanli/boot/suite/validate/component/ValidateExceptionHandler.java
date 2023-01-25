package tech.guanli.boot.suite.validate.component;

import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import tech.guanli.boot.internal.model.Returnable;
import tech.guanli.boot.internal.model.implemention.ResponseData;

@RestControllerAdvice
@Slf4j
@Order(Integer.MAX_VALUE - 1)
@ConditionalOnProperty(matchIfMissing = true, prefix = "tech.guanli.boot.validate", name = {
		"enable-default-handler" }, havingValue = "true")
public class ValidateExceptionHandler {
	/**
	 * RequestBody
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Returnable handle(MethodArgumentNotValidException exception) {
		log.warn("parameter_validate_exception:", exception);
		return ResponseData.failed(HttpStatus.BAD_REQUEST.value(), exception.getAllErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining("，")));
	}

	/**
	 * RequestBody
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Returnable handle(HttpMessageNotReadableException exception) {
		log.warn("parameter_validate_exception:", exception);
		return ResponseData.failed(HttpStatus.BAD_REQUEST.value(), "request body is missing");
	}

	/**
	 * RequestParam
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(BindException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Returnable handle(BindException exception) {
		log.warn("parameter_validate_exception:", exception);
		return ResponseData.failed(HttpStatus.BAD_REQUEST.value(), exception.getAllErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining("，")));
	}

	/**
	 * PathVariable
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Returnable handle(ConstraintViolationException exception) {
		log.warn("parameter_validate_exception:", exception);
		return ResponseData.failed(HttpStatus.BAD_REQUEST.value(), exception.getConstraintViolations().stream()
				.map(ConstraintViolation<?>::getMessage).collect(Collectors.joining("，")));
	}
}
