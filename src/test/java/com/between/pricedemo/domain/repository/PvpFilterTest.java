package com.between.pricedemo.domain.repository;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PvpFilterTest {

    private static final String DATE_STRING = "2020-06-14T10:00:00";

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Test
    void when_object_is_created_then_data_can_be_retrieved() {
        PvpFilter actual = new PvpFilter(
                1L,
                2L,
                LocalDateTime.parse(DATE_STRING, FORMATTER)
        );

        assertEquals(1L, actual.getProductId());
        assertEquals(2L, actual.getBrandId());
        assertEquals(LocalDateTime.parse("2020-06-14T10:00:00", FORMATTER), actual.getApplicationDate());
    }


}