package com.between.pricedemo.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ValidationException extends Exception {

    private final String field;
    private final String code;

}
