package com.between.pricedemo.application.configuration.exception_handler;

import com.between.pricedemo.application.configuration.exception_handler.response.ErrorResponse;
import com.between.pricedemo.domain.exception.CannotAvailablePvpException;
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
public class CannotAvailablePvpExceptionHandler {

    @ExceptionHandler(CannotAvailablePvpException.class)
    public ResponseEntity<Object> handleAvailablePvp(CannotAvailablePvpException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());

        log.error(ex.getMessage(), ex);

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
