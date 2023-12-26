package com.between.pricedemo.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Pvp {

    private final Long productId;
    private final Long brandId;
    private final Long priceId;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final BigDecimal price;

}
