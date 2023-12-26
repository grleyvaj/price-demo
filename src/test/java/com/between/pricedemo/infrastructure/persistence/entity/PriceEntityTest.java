package com.between.pricedemo.infrastructure.persistence.entity;

import com.between.pricedemo.domain.entity.Pvp;
import com.between.pricedemo.utils.FakeClock;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceEntityTest {

    @Test
    void when_object_is_created_then_data_can_be_retrieved() {
        PriceEntity actual = new PriceEntity()
                .setId(6L)
                .setProductId(7L)
                .setBrandId(8L)
                .setStartDate(FakeClock.pastDateTime())
                .setEndDate(FakeClock.future())
                .setPrice(new BigDecimal("23.0"));

        assertEquals(6L, actual.getId());
        assertEquals(7L, actual.getProductId());
        assertEquals(8L, actual.getBrandId());
        assertEquals(FakeClock.pastDateTime(), actual.getStartDate());
        assertEquals(FakeClock.future(), actual.getEndDate());
        assertEquals(new BigDecimal("23.0"), actual.getPrice());
    }

}