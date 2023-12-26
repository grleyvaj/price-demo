package com.between.pricedemo.application.configuration.exception_handler;

import com.between.pricedemo.application.configuration.exception_handler.response.ValidationErrorResponse;
import com.between.pricedemo.application.configuration.exception_handler.response.ValidationErrorResponseCreator;
import com.between.pricedemo.application.configuration.exception_handler.response.ValidationErrorResponseList;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class ConstraintViolationExceptionHandler {

    private final ValidationErrorResponseCreator validationErrorResponseCreator;

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        List<ValidationErrorResponse> errorResponseList = new ArrayList<>();

        ex.getConstraintViolations().forEach(violation -> {
            log.error("Validation error: {}", violation.getMessageTemplate());
            errorResponseList.add(
                    this.validationErrorResponseCreator.create(violation.getMessageTemplate())
                            .setField(violation.getPropertyPath().toString().split("\\.")[1])
            );
        });


        return new ResponseEntity<>(new ValidationErrorResponseList(errorResponseList), HttpStatus.BAD_REQUEST);
    }

}
