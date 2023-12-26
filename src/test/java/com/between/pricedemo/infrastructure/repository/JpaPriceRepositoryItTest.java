package com.between.pricedemo.infrastructure.repository;

import com.between.pricedemo.domain.entity.Pvp;
import com.between.pricedemo.domain.repository.PvpFilter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class JpaPriceRepositoryItTest {

    @Autowired
    private JpaPriceRepository repository;

    @Test
    void test_when_check_price_but_this_price_not_exist_then_its_exist() {
        assertTrue(this.repository.exist(1L));
    }


    @Test
    void test_when_get_pvp_but_this_price_not_exist_then_its_not_exist() {
        assertFalse(this.repository.exist(100L));
    }

    @Test
    void test1_when_filter_by_at_10h_day14_product3455_then_pvp_is_price1_with_query() {
        String applicationDateInput = "2020-06-14T10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateInput, formatter);

        PvpFilter filterTest1 = new PvpFilter(35455L, 1L, applicationDate);

        Optional<Pvp> pvp = this.repository.findByWithQuery(filterTest1);

        assertTrue(pvp.isPresent());
        assertEquals(new BigDecimal("35.50"), pvp.get().getPrice());
        assertEquals(1L, pvp.get().getPriceId());
    }

    @Test
    void test2_when_filter_by_at_16h_day14_product3455_then_pvp_is_price2_with_query() {
        String applicationDateInput = "2020-06-14T16:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateInput, formatter);

        PvpFilter filterTest1 = new PvpFilter(35455L, 1L, applicationDate);

        Optional<Pvp> pvp = this.repository.findByWithQuery(filterTest1);

        assertTrue(pvp.isPresent());
        assertEquals(new BigDecimal("25.45"), pvp.get().getPrice());
        assertEquals(2L, pvp.get().getPriceId());
    }

    @Test
    void test3_when_filter_by_at_21h_day14_product3455_then_pvp_is_price1_with_query() {
        String applicationDateInput = "2020-06-14T21:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateInput, formatter);

        PvpFilter filterTest1 = new PvpFilter(35455L, 1L, applicationDate);

        Optional<Pvp> pvp = this.repository.findByWithQuery(filterTest1);

        assertTrue(pvp.isPresent());
        assertEquals(new BigDecimal("35.50"), pvp.get().getPrice());
        assertEquals(1L, pvp.get().getPriceId());
    }

    @Test
    void test4_when_filter_by_at_10h_day15_product3455_then_pvp_is_price3_with_query() {
        String applicationDateInput = "2020-06-15T10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateInput, formatter);

        PvpFilter filterTest1 = new PvpFilter(35455L, 1L, applicationDate);

        Optional<Pvp> pvp = this.repository.findByWithQuery(filterTest1);

        assertTrue(pvp.isPresent());
        assertEquals(new BigDecimal("30.50"), pvp.get().getPrice());
        assertEquals(3L, pvp.get().getPriceId());
    }

    @Test
    void test5_when_filter_by_at_21h_day16_product3455_then_pvp_is_price4_with_query() {
        String applicationDateInput = "2020-06-16T21:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateInput, formatter);

        PvpFilter filterTest1 = new PvpFilter(35455L, 1L, applicationDate);

        Optional<Pvp> pvp = this.repository.findByWithQuery(filterTest1);

        assertTrue(pvp.isPresent());
        assertEquals(new BigDecimal("38.95"), pvp.get().getPrice());
        assertEquals(4L, pvp.get().getPriceId());
    }

    @Test
    void test1_when_filter_by_at_10h_day14_product3455_then_pvp_is_price1_with_spec() {
        String applicationDateInput = "2020-06-14T10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateInput, formatter);

        PvpFilter filterTest1 = new PvpFilter(35455L, 1L, applicationDate);

        Optional<Pvp> pvp = this.repository.findByWithSpec(filterTest1);

        assertTrue(pvp.isPresent());
        assertEquals(new BigDecimal("35.50"), pvp.get().getPrice());
        assertEquals(1L, pvp.get().getPriceId());
    }

    @Test
    void test2_when_filter_by_at_16h_day14_product3455_then_pvp_is_price2_with_spec() {
        String applicationDateInput = "2020-06-14T16:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateInput, formatter);

        PvpFilter filterTest1 = new PvpFilter(35455L, 1L, applicationDate);

        Optional<Pvp> pvp = this.repository.findByWithSpec(filterTest1);

        assertTrue(pvp.isPresent());
        assertEquals(new BigDecimal("25.45"), pvp.get().getPrice());
        assertEquals(2L, pvp.get().getPriceId());
    }

    @Test
    void test3_when_filter_by_at_21h_day14_product3455_then_pvp_is_price1_with_spec() {
        String applicationDateInput = "2020-06-14T21:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateInput, formatter);

        PvpFilter filterTest1 = new PvpFilter(35455L, 1L, applicationDate);

        Optional<Pvp> pvp = this.repository.findByWithSpec(filterTest1);

        assertTrue(pvp.isPresent());
        assertEquals(new BigDecimal("35.50"), pvp.get().getPrice());
        assertEquals(1L, pvp.get().getPriceId());
    }

    @Test
    void test4_when_filter_by_at_10h_day15_product3455_then_pvp_is_price3_with_spec() {
        String applicationDateInput = "2020-06-15T10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateInput, formatter);

        PvpFilter filterTest1 = new PvpFilter(35455L, 1L, applicationDate);

        Optional<Pvp> pvp = this.repository.findByWithSpec(filterTest1);

        assertTrue(pvp.isPresent());
        assertEquals(new BigDecimal("30.50"), pvp.get().getPrice());
        assertEquals(3L, pvp.get().getPriceId());
    }

    @Test
    void test5_when_filter_by_at_21h_day16_product3455_then_pvp_is_price4_with_spec() {
        String applicationDateInput = "2020-06-16T21:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateInput, formatter);

        PvpFilter filterTest1 = new PvpFilter(35455L, 1L, applicationDate);

        Optional<Pvp> pvp = this.repository.findByWithSpec(filterTest1);

        assertTrue(pvp.isPresent());
        assertEquals(new BigDecimal("38.95"), pvp.get().getPrice());
        assertEquals(4L, pvp.get().getPriceId());
    }

    @Test
    void test_when_filter_and_price_is_not_found_then_pvp_is_not_retrieve_with_query() {
        String applicationDateInput = "2023-12-16T21:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateInput, formatter);

        PvpFilter filterTest1 = new PvpFilter(20L, 30L, applicationDate);

        Optional<Pvp> pvp = this.repository.findByWithQuery(filterTest1);

        assertFalse(pvp.isPresent());
    }

    @Test
    void test_when_filter_and_price_is_not_found_then_pvp_is_not_retrieve_with_spec() {
        String applicationDateInput = "2023-12-16T21:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateInput, formatter);

        PvpFilter filterTest1 = new PvpFilter(20L, 30L, applicationDate);

        Optional<Pvp> pvp = this.repository.findByWithSpec(filterTest1);

        assertFalse(pvp.isPresent());
    }

}