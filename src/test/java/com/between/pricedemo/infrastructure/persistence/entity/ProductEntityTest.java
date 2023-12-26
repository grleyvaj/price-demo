package com.between.pricedemo.infrastructure.persistence.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductEntityTest {

    @Test
    void when_object_is_created_then_data_can_be_retrieved() {
        ProductEntity actual = new ProductEntity()
                .setId(1L)
                .setName("::name::");

        assertEquals(1L, actual.getId());
        assertEquals("::name::", actual.getName());
    }

}