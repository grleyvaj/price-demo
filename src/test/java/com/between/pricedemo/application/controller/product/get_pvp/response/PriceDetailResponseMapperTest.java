package com.between.pricedemo.application.controller.product.get_pvp.response;

import com.between.pricedemo.domain.entity.Pvp;
import com.between.pricedemo.utils.FakeClock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PriceDetailResponseMapperTest {

    @InjectMocks
    private PriceDetailResponseMapper mapper;

    @Test
    void when_values_are_given_then_they_can_be_retrieved() {
        Pvp pvpFake = new Pvp(
                1L,
                2L,
                3L,
                FakeClock.now(),
                FakeClock.future(),
                BigDecimal.valueOf(35.50)
        );

        PriceDetailResponse response = this.mapper.map(pvpFake);

        assertEquals(1L, response.getProductId());
        assertEquals(2L, response.getBrandId());
        assertEquals(3L, response.getPriceId());
        assertEquals(FakeClock.now(), response.getStartDate());
        assertEquals(FakeClock.future(), response.getEndDate());
        assertEquals(BigDecimal.valueOf(35.50), response.getPvp());
    }

}