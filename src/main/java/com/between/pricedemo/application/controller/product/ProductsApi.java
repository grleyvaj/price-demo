package com.between.pricedemo.application.controller.product;

import com.between.pricedemo.application.configuration.exception_handler.response.ValidationErrorResponse;
import com.between.pricedemo.application.controller.product.get_pvp.response.PriceDetailResponse;
import com.between.pricedemo.application.validator.BrandExist;
import com.between.pricedemo.application.validator.ProductExist;
import com.between.pricedemo.domain.exception.CannotAvailablePvpException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "${api.tag.price.name}", description = "${api.tag.price.description}")
public interface ProductsApi {

    @Operation(
            summary = "${api.brand.get_pvp.summary}",
            description = "${api.brand.get_pvp.description}",
            operationId = "get_pvp"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.price.get_pvp.response.description}",
                    content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = PriceDetailResponse.class))}),
            @ApiResponse(responseCode = "400", description = "${api.response.400.description}",
                    content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "${api.response.401.description}", content = @Content),
            @ApiResponse(responseCode = "403", description = "${api.response.403.description}", content = @Content),
            @ApiResponse(responseCode = "404", description = "${api.response.404.description}", content = @Content),
            @ApiResponse(responseCode = "500", description = "${api.response.500.description}", content = @Content)
    })
    ResponseEntity<PriceDetailResponse> get_pvp(
            @Parameter(in = ParameterIn.PATH, description = "${product.id.description}", schema = @Schema(implementation = Long.class), required = true, name = "productId") @ProductExist(message = "product.notFound") Long productId,
            @Parameter(in = ParameterIn.PATH, description = "${brand.id.description}", schema = @Schema(implementation = Long.class), required = true, name = "brandId") @BrandExist(message = "brand.notFound") Long brandId,
            @Parameter(in = ParameterIn.QUERY, description = "${price.applicationDate.description}", schema = @Schema(implementation = LocalDateTime.class), required = true) @NotNull(message = "brand.applicationDate.null") LocalDateTime applicationDate
    ) throws CannotAvailablePvpException;

}
