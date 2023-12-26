package com.between.pricedemo.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {


    @Test
    void when_object_is_created_then_data_can_be_retrieved() {
        Product actual = new Product(
                1L,
                "::name::"
        );

        assertEquals(1L, actual.getId());
        assertEquals("::name::", actual.getName());
    }

}