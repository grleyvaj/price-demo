package com.between.pricedemo.infrastructure.persistence.entity;

import com.between.pricedemo.domain.repository.BrandCreateInput;
import com.between.pricedemo.utils.FakeClock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BrandEntityMapperTest {

    private BrandEntityMapper mapper;

    @BeforeEach
    void setUp() {
        this.mapper = new BrandEntityMapper(FakeClock.nowClock());
    }

    @Test
    void when_values_are_given_then_they_can_be_retrieved() {
        BrandCreateInput brandInput = new BrandCreateInput(
                "::name::",
                "ES"
        ).setSector("::sector::");

        BrandEntity response = this.mapper.map(brandInput);

        assertEquals("::name::", response.getName());
        assertEquals("ES", response.getCountryCode());
        assertEquals("::sector::", response.getSector());
        assertEquals(FakeClock.now(), response.getCreatedAt());
    }

}