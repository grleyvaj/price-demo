package com.between.pricedemo.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidationExceptionTest {

    @Test
    public void when_object_is_created_data_can_be_retrieved() {
        ValidationException actual = new ValidationException("::field::", "::code::");

        assertEquals("::field::", actual.getField());
        assertEquals("::code::", actual.getCode());
    }

}