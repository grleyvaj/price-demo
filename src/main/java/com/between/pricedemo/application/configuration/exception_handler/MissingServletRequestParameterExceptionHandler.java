package com.between.pricedemo.application.configuration.exception_handler;

import com.between.pricedemo.application.configuration.exception_handler.response.ValidationErrorResponse;
import com.between.pricedemo.application.configuration.exception_handler.response.ValidationErrorResponseList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class MissingServletRequestParameterExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handleMissingServletRequest(MissingServletRequestParameterException ex) {
        List<ValidationErrorResponse> errorResponseList = new ArrayList<>();

        errorResponseList.add(
                new ValidationErrorResponse(
                        String.format("%s.required", ex.getParameterName()),
                        String.format("The %s is required", ex.getParameterName()),
                        String.format("The %s cannot be null. Please provide a valid one. ", ex.getParameterName())
                ).setField(ex.getParameterName())
        );

        return new ResponseEntity<>(new ValidationErrorResponseList(errorResponseList), HttpStatus.BAD_REQUEST);
    }

}
