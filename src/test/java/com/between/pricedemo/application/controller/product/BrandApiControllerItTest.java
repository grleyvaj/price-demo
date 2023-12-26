package com.between.pricedemo.application.controller.product;

import com.between.pricedemo.application.controller.brand.create.request.BrandCreateRequest;
import com.between.pricedemo.application.controller.brand.create.response.BrandCreateResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class BrandApiControllerItTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void test_when_create_brand_then_its_created() throws Exception {
        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/brands")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(
                        new BrandCreateRequest()
                                .setName("::name::")
                                .setCountryCode("ES")
                                .setSector("::sector:")
                ))
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void test_when_create_brand_then_retrieved_data_is_ok() throws Exception {
        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/brands")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(
                        new BrandCreateRequest()
                                .setName("::name::")
                                .setCountryCode("ES")
                                .setSector("::sector::")
                ))
        ).andReturn().getResponse();

        BrandCreateResponse responseBody = this.objectMapper.readValue(
                response.getContentAsString(),
                new TypeReference<>() {
                });

        assertNotNull(responseBody.getId());
        assertEquals("::name::", responseBody.getName());
        assertEquals("ES", responseBody.getCountryCode());
        assertEquals(Optional.of("::sector::"), responseBody.getSector());
    }

}