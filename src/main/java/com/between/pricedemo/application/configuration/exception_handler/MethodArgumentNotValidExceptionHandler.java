package com.between.pricedemo.application.configuration.exception_handler;

import com.between.pricedemo.application.configuration.exception_handler.response.ValidationErrorResponse;
import com.between.pricedemo.application.configuration.exception_handler.response.ValidationErrorResponseCreator;
import com.between.pricedemo.application.configuration.exception_handler.response.ValidationErrorResponseList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class MethodArgumentNotValidExceptionHandler {

    private final ValidationErrorResponseCreator validationErrorResponseCreator;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleInvalidArgument(MethodArgumentNotValidException ex) {
        List<ValidationErrorResponse> errorResponseList = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            log.error("Validation error: {}", error.getDefaultMessage());
            errorResponseList.add(this.validationErrorResponseCreator.create(error.getDefaultMessage()).setField(error.getField()));
        });
        ex.getBindingResult().getGlobalErrors().forEach(error -> {
            log.error("Validation error: {}", error.getDefaultMessage());
            errorResponseList.add(this.validationErrorResponseCreator.create(error.getDefaultMessage()).setField(error.getObjectName()));
        });

        return new ResponseEntity<>(new ValidationErrorResponseList(errorResponseList), HttpStatus.BAD_REQUEST);
    }

}
