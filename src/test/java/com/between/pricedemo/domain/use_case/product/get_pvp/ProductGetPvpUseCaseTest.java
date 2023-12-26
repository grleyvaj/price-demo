package com.between.pricedemo.domain.use_case.product.get_pvp;

import com.between.pricedemo.domain.entity.MethodApply;
import com.between.pricedemo.domain.entity.Pvp;
import com.between.pricedemo.domain.exception.CannotAvailablePvpException;
import com.between.pricedemo.domain.repository.PriceRepository;
import com.between.pricedemo.domain.repository.PvpFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductGetPvpUseCaseTest {

    private static final String DATE_STRING = "2020-06-14T10:00:00";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    private ProductGetPvpUseCase useCase;

    @Mock
    private PriceRepository priceRepository;

    @Mock
    private MethodApply method;

    @BeforeEach
    void setUp() {
        this.useCase = new ProductGetPvpUseCase(
                this.priceRepository,
                MethodApply.QUERY
        );
    }

    @Test
    void test_when_use_case_is_invoked_and_query_method_is_invoked_then_query_is_executed() throws CannotAvailablePvpException {
        PvpFilter filterInput = new PvpFilter(35455L, 1L, LocalDateTime.parse(DATE_STRING, FORMATTER));
        Pvp pvpFake = new Pvp(
                1L,
                1L,
                1L,
                LocalDateTime.parse("2020-06-14T00:00:00", FORMATTER),
                LocalDateTime.parse("2020-12-31T23:59:59", FORMATTER),
                BigDecimal.valueOf(35.50)
        );
        when(this.priceRepository.findByWithQuery(any(PvpFilter.class))).thenReturn(Optional.of(pvpFake));

        this.useCase.execute(filterInput);

        verify(this.priceRepository).findByWithQuery(filterInput);
    }

    @Test
    void test_when_use_case_is_invoked_and_specification_method_is_invoked_then_query_with_spec_is_executed() throws CannotAvailablePvpException {
        PvpFilter filterInput = new PvpFilter(35455L, 1L, LocalDateTime.parse(DATE_STRING, FORMATTER));
        Pvp pvpFake = new Pvp(
                1L,
                1L,
                1L,
                LocalDateTime.parse("2020-06-14T00:00:00", FORMATTER),
                LocalDateTime.parse("2020-12-31T23:59:59", FORMATTER),
                BigDecimal.valueOf(35.50)
        );
        this.useCase = new ProductGetPvpUseCase(priceRepository, MethodApply.SPECIFICATION);
        when(this.priceRepository.findByWithSpec(any(PvpFilter.class))).thenReturn(Optional.of(pvpFake));

        this.useCase.execute(filterInput);

        verify(this.priceRepository).findByWithSpec(filterInput);
    }

    @Test
    void test_when_use_case_is_invoked_and_price_is_not_found_then_error_is_thrown() throws CannotAvailablePvpException {
        PvpFilter filterInput = new PvpFilter(35455L, 1L, LocalDateTime.parse(DATE_STRING, FORMATTER));
        when(this.priceRepository.findByWithQuery(any(PvpFilter.class))).thenReturn(Optional.empty());

        assertThrows(
                CannotAvailablePvpException.class,
                () -> this.useCase.execute(filterInput)
        );
    }

    @Test
    void test_when_use_case_is_invoked_and_price_is_found_then_its_retrieved() throws CannotAvailablePvpException {
        PvpFilter filterInput = new PvpFilter(35455L, 1L, LocalDateTime.parse(DATE_STRING, FORMATTER));
        Pvp pvpFake = new Pvp(
                1L,
                1L,
                1L,
                LocalDateTime.parse("2020-06-14T00:00:00", FORMATTER),
                LocalDateTime.parse("2020-12-31T23:59:59", FORMATTER),
                BigDecimal.valueOf(35.50)
        );
        when(this.priceRepository.findByWithQuery(any(PvpFilter.class))).thenReturn(Optional.of(pvpFake));

        Pvp pvp = this.useCase.execute(filterInput);

        assertEquals(pvpFake, pvp);
    }

}