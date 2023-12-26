package com.between.pricedemo.domain.entity;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrandTest {

    @Test
    void when_object_is_created_then_data_can_be_retrieved() {
        Brand actual = new Brand(
                1L,
                "::name::",
                "ES"
        ).setSector("::sector::");

        assertEquals(1L, actual.getId());
        assertEquals("::name::", actual.getName());
        assertEquals("ES", actual.getCountryCode());
        assertEquals(Optional.of("::sector::"), actual.getSector());
    }

    @Test
    void when_sector_is_not_given_then_its_not_retrieved() {
        Brand actual = new Brand(
                1L,
                "::name::",
                "ES"
        ).setSector(null);

        assertEquals(Optional.empty(), actual.getSector());
    }

}