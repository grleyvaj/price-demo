package com.between.pricedemo.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class Product {

    private final Long id;
    private final String name;

}
