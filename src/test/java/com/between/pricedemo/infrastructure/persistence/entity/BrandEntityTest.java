package com.between.pricedemo.infrastructure.persistence.entity;

import com.between.pricedemo.utils.FakeClock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrandEntityTest {

    @Test
    void when_object_is_created_then_data_can_be_retrieved() {
        BrandEntity actual = new BrandEntity()
                .setId(3L)
                .setName("::name::")
                .setCountryCode("ES")
                .setSector("::sector::")
                .setCreatedAt(FakeClock.now());

        assertEquals(3L, actual.getId());
        assertEquals("::name::", actual.getName());
        assertEquals("ES", actual.getCountryCode());
        assertEquals("::sector::", actual.getSector());
        assertEquals(FakeClock.now(), actual.getCreatedAt());
    }

}