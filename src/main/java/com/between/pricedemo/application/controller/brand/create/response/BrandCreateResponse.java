package com.between.pricedemo.application.controller.brand.create.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;

@Accessors(chain = true)
@Data
@Schema(description = "${api.brand.create.response.description}")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BrandCreateResponse {

    @JsonProperty("id")
    @NotNull(message = "response.id.required")
    @Schema(description = "${brand.id.description}", example = "20")
    private final Long id;

    @JsonProperty("name")
    @NotNull(message = "brand.name.null")
    @Schema(description = "${brand.name.description}", example = "Google")
    private final String name;

    @JsonProperty("countryCode")
    @NotNull(message = "brand.country.null")
    @Schema(description = "${brand.country.description}", example = "USA")
    private final String countryCode;

    @JsonProperty("sector")
    @Schema(description = "${brand.sector.description}", example = "Technology")
    private String sector;

    public Optional<String> getSector() {
        return Optional.ofNullable(sector);
    }

}
