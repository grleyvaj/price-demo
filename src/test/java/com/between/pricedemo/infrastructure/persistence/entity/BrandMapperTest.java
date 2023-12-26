package com.between.pricedemo.infrastructure.persistence.entity;

import com.between.pricedemo.domain.entity.Brand;
import com.between.pricedemo.utils.FakeClock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BrandMapperTest {

    @InjectMocks
    private BrandMapper mapper;

    @Test
    void when_values_are_given_then_they_can_be_retrieved() {
        BrandEntity brandEntity = new BrandEntity()
                .setId(3L)
                .setName("::name::")
                .setCountryCode("ES")
                .setSector("::sector::")
                .setCreatedAt(FakeClock.now());

        Brand response = this.mapper.map(brandEntity);

        assertEquals("::name::", response.getName());
        assertEquals("ES", response.getCountryCode());
        assertEquals(Optional.of("::sector::"), response.getSector());
    }

    @Test
    void when_sector_is_not_given_then_value_cannot_retrieved() {
        BrandEntity brandEntity = new BrandEntity()
                .setId(3L)
                .setName("::name::")
                .setCountryCode("ES")
                .setSector(null)
                .setCreatedAt(FakeClock.now());

        Brand response = this.mapper.map(brandEntity);

        assertEquals("::name::", response.getName());
        assertEquals("ES", response.getCountryCode());
        assertEquals(Optional.empty(), response.getSector());
    }

}