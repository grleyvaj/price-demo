package com.between.pricedemo.application.controller.brand.create.request;

import com.between.pricedemo.application.validator.NotBlankIfPresent;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Schema(description = "${api.brand.create.request.description}")
public class BrandCreateRequest {

    @JsonProperty("name")
    @NotNull(message = "brand.name.null")
    @NotBlank(message = "brand.name.blank")
    @Size(max = 100, message = "brand.name.size")
    @Schema(description = "${brand.name.description}", example = "Google")
    private String name;

    @JsonProperty("countryCode")
    @NotNull(message = "brand.country.null")
    @NotBlank(message = "brand.country.blank")
    @Size(max = 3, message = "brand.country.size")
    @Schema(description = "${brand.country.description}", example = "USA")
    private String countryCode;

    @JsonProperty("sector")
    @Size(max = 100, message = "brand.sector.size")
    @NotBlankIfPresent(message = "brand.sector.blank")
    @Schema(description = "${brand.sector.description}", example = "Technology")
    private String sector;

}
