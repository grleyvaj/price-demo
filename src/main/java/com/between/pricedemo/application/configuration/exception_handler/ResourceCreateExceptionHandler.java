package com.between.pricedemo.application.configuration.exception_handler;

import com.between.pricedemo.application.configuration.exception_handler.response.ErrorResponse;
import com.between.pricedemo.domain.exception.ResourceCreateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class ResourceCreateExceptionHandler {

    @ExceptionHandler(ResourceCreateException.class)
    public ResponseEntity<Object> handleResourceCreateException(ResourceCreateException ex) {
        ErrorResponse errorResponse = new ErrorResponse("Error creating brand");

        log.error(ex.getMessage(), ex);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
