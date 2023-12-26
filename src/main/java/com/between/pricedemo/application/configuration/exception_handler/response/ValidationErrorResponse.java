package com.between.pricedemo.application.configuration.exception_handler.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ValidationErrorResponse {

    @Schema(name = "field", description = "${error.response.field.description}", example = "productId")
    @JsonProperty("field")
    private String field;

    @Schema(name = "code", description = "${error.response.code.description}", example = "product.notFound")
    @NotNull(message = "response.value.required")
    @JsonProperty("code")
    private final String code;

    @Schema(name = "title", description = "${error.response.title.description}", example = "Product not found")
    @NotNull(message = "response.value.required")
    @JsonProperty("title")
    private final String title;

    @Schema(name = "detail", description = "${error.response.detail.description}", example = "The product ID you requested was not found.")
    @NotNull(message = "response.value.required")
    @JsonProperty("detail")
    private final String detail;

}
