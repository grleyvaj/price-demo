package com.between.pricedemo.application.controller.product.get_pvp.response;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceDetailResponseTest {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Test
    public void when_object_is_created_then_data_can_be_retrieved() {
        PriceDetailResponse actual = new PriceDetailResponse(
                1L,
                2L,
                3L,
                LocalDateTime.parse("2020-06-14T00:00:00", FORMATTER),
                LocalDateTime.parse("2020-06-15T00:00:00", FORMATTER),
                new BigDecimal("23.0")
        );

        assertEquals(1L, actual.getProductId());
        assertEquals(2L, actual.getBrandId());
        assertEquals(3L, actual.getPriceId());
        assertEquals(LocalDateTime.parse("2020-06-14T00:00:00", FORMATTER), actual.getStartDate());
        assertEquals(LocalDateTime.parse("2020-06-15T00:00:00", FORMATTER), actual.getEndDate());
        assertEquals(new BigDecimal("23.0"), actual.getPvp());
    }

}