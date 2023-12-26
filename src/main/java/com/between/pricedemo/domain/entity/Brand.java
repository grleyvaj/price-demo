package com.between.pricedemo.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;

@Accessors(chain = true)
@Data
public class Brand {

    private final Long id;
    private final String name;
    private final String countryCode;
    private String sector;

    public Optional<String> getSector() {
        return Optional.ofNullable(sector);
    }

}
