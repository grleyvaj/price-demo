package com.between.pricedemo.application.controller.product.get_pvp.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PriceDetailResponse {

    @JsonProperty("productId")
    @NotNull(message = "response.value.required")
    @Schema(description = "${product.id.description}", example = "35455")
    private final Long productId;

    @JsonProperty("brandId")
    @NotNull(message = "response.value.required")
    @Schema(description = "${brand.id.description}", example = "1")
    private final Long brandId;

    @JsonProperty("priceId")
    @Schema(description = "${price.id.description}", example = "35455")
    private final Long priceId;

    @JsonProperty("startDate")
    @NotNull(message = "response.value.required")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Schema(description = "${price.startDate.description}", example = "2020-06-14T00:00:00")
    private final LocalDateTime startDate;

    @JsonProperty("endDate")
    @NotNull(message = "response.value.required")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Schema(description = "${price.endDate.description}", example = "2020-12-31T23:59:59")
    private final LocalDateTime endDate;

    @JsonProperty("pvp")
    @NotNull(message = "response.value.required")
    @Schema(description = "${price.pvp.description}", example = "35.50")
    private final BigDecimal pvp;

}
