package com.between.pricedemo.application.controller.product;

import com.between.pricedemo.application.contract.Mapper;
import com.between.pricedemo.application.controller.product.get_pvp.response.PriceDetailResponse;
import com.between.pricedemo.domain.entity.Pvp;
import com.between.pricedemo.domain.exception.CannotAvailablePvpException;
import com.between.pricedemo.domain.repository.PvpFilter;
import com.between.pricedemo.domain.use_case.product.get_pvp.ProductGetPvpUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductsApiControllerTest {

    private static final String DATE_STRING = "2020-06-14T10:00:00";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    private ProductsApiController controller;

    @Mock
    private ProductGetPvpUseCase useCase;

    @Mock
    private Mapper<Pvp, PriceDetailResponse> responseMapper;

    @BeforeEach
    public void setUp() {
        this.controller = new ProductsApiController(
                this.useCase,
                this.responseMapper
        );
    }

    @Test
    void test_when_get_pvp_request_is_process_then_pvp_is_searched() throws CannotAvailablePvpException {
        this.controller.get_pvp(1L, 1L, LocalDateTime.parse(DATE_STRING, FORMATTER));

        verify(this.useCase).execute(new PvpFilter(1L, 1L, LocalDateTime.parse(DATE_STRING, FORMATTER)));
    }

    @Test
    void test_when_get_pvp_request_is_process_and_pvp_is_not_found_then_error_is_thrown() throws CannotAvailablePvpException {
        doThrow(CannotAvailablePvpException.class).when(this.useCase).execute(any());

        assertThrows(
                CannotAvailablePvpException.class,
                () -> this.controller.get_pvp(1L, 1L, LocalDateTime.parse(DATE_STRING, FORMATTER))
        );
        verifyNoInteractions(this.responseMapper);
    }

    @Test
    void test_when_get_pvp_request_is_process_and_pvp_is_found_then_pvp_info_is_mapped() throws CannotAvailablePvpException {
        Pvp expectedPvp = new Pvp(
                1L,
                1L,
                1L,
                LocalDateTime.parse("2020-06-14T00:00:00", FORMATTER),
                LocalDateTime.parse("2020-12-31T23:59:59", FORMATTER),
                BigDecimal.valueOf(35.50)
        );
        when(this.useCase.execute(any(PvpFilter.class))).thenReturn(expectedPvp);

        this.controller.get_pvp(1L, 1L, LocalDateTime.parse(DATE_STRING, FORMATTER));

        verify(this.responseMapper).map(expectedPvp);
    }


    @Test
    void test_when_get_pvp_request_is_process_and_pvp_is_mapped_then_its_retrieved() throws CannotAvailablePvpException {
        Pvp expectedPvp = new Pvp(
                1L,
                1L,
                1L,
                LocalDateTime.parse("2020-06-14T00:00:00", FORMATTER),
                LocalDateTime.parse("2020-12-31T23:59:59", FORMATTER),
                BigDecimal.valueOf(35.50)
        );
        PriceDetailResponse expectedPvpResponse = new PriceDetailResponse(
                1L,
                1L,
                1L,
                LocalDateTime.parse("2020-06-14T00:00:00", FORMATTER),
                LocalDateTime.parse("2020-12-31T23:59:59", FORMATTER),
                BigDecimal.valueOf(35.50)
        );
        when(this.useCase.execute(any(PvpFilter.class))).thenReturn(expectedPvp);
        when(this.responseMapper.map(any(Pvp.class))).thenReturn(expectedPvpResponse);

        ResponseEntity<PriceDetailResponse> response = this.controller.get_pvp(1L, 1L, LocalDateTime.parse(DATE_STRING, FORMATTER));

        assertEquals(expectedPvpResponse, response.getBody());
    }

}