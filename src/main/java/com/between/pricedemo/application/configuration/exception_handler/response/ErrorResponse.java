package com.between.pricedemo.application.configuration.exception_handler.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class ErrorResponse {

    private final String message;

}
