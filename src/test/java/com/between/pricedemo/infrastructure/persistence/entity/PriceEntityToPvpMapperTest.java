package com.between.pricedemo.infrastructure.persistence.entity;

import com.between.pricedemo.domain.entity.Pvp;
import com.between.pricedemo.utils.FakeClock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PriceEntityToPvpMapperTest {

    @InjectMocks
    private PriceEntityToPvpMapper mapper;

    @Test
    void when_values_are_given_then_they_can_be_retrieved() {
        PriceEntity entity = new PriceEntity().setId(6L).setProductId(7L).setBrandId(8L).setStartDate(FakeClock.pastDateTime()).setEndDate(FakeClock.future()).setPrice(new BigDecimal("23.0"));

        Pvp actual = this.mapper.map(entity);

        assertEquals(6L, actual.getPriceId());
        assertEquals(7L, actual.getProductId());
        assertEquals(8L, actual.getBrandId());
        assertEquals(FakeClock.pastDateTime(), actual.getStartDate());
        assertEquals(FakeClock.future(), actual.getEndDate());
        assertEquals(new BigDecimal("23.0"), actual.getPrice());
    }

}