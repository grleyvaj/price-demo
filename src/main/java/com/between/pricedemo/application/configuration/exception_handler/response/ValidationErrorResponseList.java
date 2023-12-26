package com.between.pricedemo.application.configuration.exception_handler.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ValidationErrorResponseList {

    @JsonProperty("errors")
    private final List<ValidationErrorResponse> errors;

}
