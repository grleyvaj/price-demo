package com.between.pricedemo.domain.repository;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PvpFilter {

    private final Long productId;
    private final Long brandId;
    private final LocalDateTime applicationDate;

}
