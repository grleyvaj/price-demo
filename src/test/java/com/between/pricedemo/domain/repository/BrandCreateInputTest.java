package com.between.pricedemo.domain.repository;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrandCreateInputTest {

    @Test
    void when_object_is_created_then_data_can_be_retrieved() {
        BrandCreateInput actual = new BrandCreateInput(
                "::name::",
                "ES"
        ).setSector("::sector::");

        assertEquals("::name::", actual.getName());
        assertEquals("ES", actual.getCountryCode());
        assertEquals(Optional.of("::sector::"), actual.getSector());
    }

    @Test
    void when_sector_is_not_given_then_its_not_retrieved() {
        BrandCreateInput actual = new BrandCreateInput(
                "::name::",
                "ES"
        ).setSector(null);

        assertEquals(Optional.empty(), actual.getSector());
    }


}