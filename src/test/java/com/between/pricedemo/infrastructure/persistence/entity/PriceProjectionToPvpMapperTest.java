package com.between.pricedemo.infrastructure.persistence.entity;

import com.between.pricedemo.domain.entity.Pvp;
import com.between.pricedemo.utils.FakeClock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PriceProjectionToPvpMapperTest {

    @InjectMocks
    private PriceProjectionToPvpMapper mapper;

    @Test
    void when_values_are_given_then_they_can_be_retrieved() {
        PriceProjection projection = new PriceProjection() {
            @Override
            public Long getProductId() {
                return 2L;
            }

            @Override
            public Long getBrandId() {
                return 3L;
            }

            @Override
            public Long getId() {
                return 1L;
            }

            @Override
            public LocalDateTime getStartDate() {
                return FakeClock.now();
            }

            @Override
            public LocalDateTime getEndDate() {
                return FakeClock.future();
            }

            @Override
            public BigDecimal getPrice() {
                return new BigDecimal("23.0");
            }
        };

        Pvp actual = this.mapper.map(projection);

        assertEquals(1L, actual.getPriceId());
        assertEquals(2L, actual.getProductId());
        assertEquals(3L, actual.getBrandId());
        assertEquals(FakeClock.now(), actual.getStartDate());
        assertEquals(FakeClock.future(), actual.getEndDate());
        assertEquals(new BigDecimal("23.0"), actual.getPrice());
    }
}