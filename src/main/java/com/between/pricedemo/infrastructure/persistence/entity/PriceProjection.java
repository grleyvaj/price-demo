package com.between.pricedemo.infrastructure.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PriceProjection {
    Long getProductId();

    Long getBrandId();

    Long getId();

    LocalDateTime getStartDate();

    LocalDateTime getEndDate();

    BigDecimal getPrice();
}
