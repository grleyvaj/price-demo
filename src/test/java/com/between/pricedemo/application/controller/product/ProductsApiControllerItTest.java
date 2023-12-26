package com.between.pricedemo.application.controller.product;

import com.between.pricedemo.application.contract.Mapper;
import com.between.pricedemo.application.controller.product.get_pvp.response.PriceDetailResponse;
import com.between.pricedemo.domain.entity.Pvp;
import com.between.pricedemo.domain.repository.PvpFilter;
import com.between.pricedemo.domain.use_case.product.get_pvp.ProductGetPvpUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DirtiesContext
class ProductsApiControllerItTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductGetPvpUseCase productGetPvpUseCase;

    @MockBean
    private Mapper<Pvp, PriceDetailResponse> pvpPriceDetailResponseMapper;

    @Test
    void test_when_get_pvp_request_is_call_then_request_is_processed() throws Exception {
        String dateString = "2020-06-14T10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/products/1/brands/1/pvp")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("applicationDate", "2020-06-14T10:00:00")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void test_when_get_pvp_request_is_call_then_price_is_calculated() throws Exception {
        String dateString = "2020-06-14T10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);

        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/products/1/brands/1/pvp")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("applicationDate", "2020-06-14T10:00:00")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        verify(this.productGetPvpUseCase).execute(new PvpFilter(1L, 1L, localDateTime));
    }

    @Test
    void test_when_get_pvp_request_is_call_and_data_is_searched_then_price_data_is_mapped() throws Exception {
        String dateString = "2020-06-14T10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);

        Pvp pvpFake = new Pvp(
                1L,
                1L,
                1L,
                LocalDateTime.parse("2020-06-14T00:00:00", formatter),
                LocalDateTime.parse("2020-12-31T23:59:59", formatter),
                BigDecimal.valueOf(35.50)
        );
        when(this.productGetPvpUseCase.execute(new PvpFilter(1L, 1L, localDateTime)))
                .thenReturn(pvpFake);

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/products/1/brands/1/pvp")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("applicationDate", "2020-06-14T10:00:00")
        ).andReturn().getResponse();

        verify(this.pvpPriceDetailResponseMapper).map(pvpFake);
    }

    @Test
    void test_when_get_pvp_request_is_call_and_data_is_mapped_then_its_retrieved() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        Pvp pvpFake = new Pvp(
                1L,
                1L,
                1L,
                LocalDateTime.parse("2020-06-14T00:00:00", formatter),
                LocalDateTime.parse("2020-12-31T23:59:59", formatter),
                BigDecimal.valueOf(35.50)
        );
        PriceDetailResponse pvpResponse = new PriceDetailResponse(
                1L,
                1L,
                1L,
                LocalDateTime.parse("2020-06-14T00:00:00", formatter),
                LocalDateTime.parse("2020-12-31T23:59:59", formatter),
                BigDecimal.valueOf(35.50)
        );
        when(this.productGetPvpUseCase.execute(any(PvpFilter.class))).thenReturn(pvpFake);
        when(this.pvpPriceDetailResponseMapper.map(any(Pvp.class))).thenReturn(pvpResponse);

        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/products/1/brands/1/pvp")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("applicationDate", "2020-06-14T10:00:00")
        ).andReturn().getResponse();

        String content = response.getContentAsString();
        PriceDetailResponse responseBody = this.objectMapper.readValue(content, PriceDetailResponse.class);

        assertEquals(1L, responseBody.getBrandId());
        assertEquals(1L, responseBody.getProductId());
        assertEquals(1L, responseBody.getPriceId());
        assertEquals(LocalDateTime.parse("2020-06-14T00:00:00", formatter), responseBody.getStartDate());
        assertEquals(LocalDateTime.parse("2020-12-31T23:59:59"), responseBody.getEndDate());
        assertEquals(BigDecimal.valueOf(35.50), responseBody.getPvp());
    }

}