package com.between.pricedemo.domain.entity;

import com.between.pricedemo.utils.FakeClock;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PvpTest {

    @Test
    void when_object_is_created_then_data_can_be_retrieved() {
        Pvp actual = new Pvp(
                1L,
                2L,
                3L,
                FakeClock.pastDateTime(),
                FakeClock.future(),
                new BigDecimal("23.0")
        );

        assertEquals(1L, actual.getProductId());
        assertEquals(2L, actual.getBrandId());
        assertEquals(3L, actual.getPriceId());
        assertEquals(FakeClock.pastDateTime(), actual.getStartDate());
        assertEquals(FakeClock.future(), actual.getEndDate());
        assertEquals(new BigDecimal("23.0"), actual.getPrice());
    }

}