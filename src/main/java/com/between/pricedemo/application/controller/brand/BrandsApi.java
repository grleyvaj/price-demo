package com.between.pricedemo.application.controller.brand;

import com.between.pricedemo.application.configuration.exception_handler.response.ValidationErrorResponse;
import com.between.pricedemo.application.controller.brand.create.request.BrandCreateRequest;
import com.between.pricedemo.application.controller.brand.create.response.BrandCreateResponse;
import com.between.pricedemo.domain.exception.ResourceCreateException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "${api.tag.brand.name}", description = "${api.tag.brand.description}")
public interface BrandsApi {

    @Operation(
            summary = "${api.brand.create.summary}",
            description = "${api.brand.create.description}",
            operationId = "create"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "${api.brand.create.response.description}",
                    content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = BrandCreateResponse.class))),
            @ApiResponse(responseCode = "400", description = "${api.response.400.description}",
                    content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "${api.response.401.description}", content = @Content),
            @ApiResponse(responseCode = "403", description = "${api.response.403.description}", content = @Content),
            @ApiResponse(responseCode = "500", description = "${api.response.500.description}", content = @Content)
    })
    ResponseEntity<BrandCreateResponse> create(
            @Parameter(description = "${api.brand.create.request.description}", schema = @Schema(implementation = BrandCreateRequest.class), required = true) @Valid BrandCreateRequest request
    ) throws ResourceCreateException;

}
