package com.between.pricedemo.infrastructure.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class JpaProductRepositoryItTest {

    @Autowired
    private JpaProductRepository repository;

    @Test
    void test_when_check_product_but_this_product_not_exist_then_its_exist() {
        assertTrue(this.repository.exist(1L));
    }

    @Test
    void test_when_check_product_but_this_product_not_exist_then_its_not_exist() {
        assertFalse(this.repository.exist(100L));
    }

}