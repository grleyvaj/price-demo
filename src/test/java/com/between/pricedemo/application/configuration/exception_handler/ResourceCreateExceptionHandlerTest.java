package com.between.pricedemo.application.configuration.exception_handler;

import com.between.pricedemo.application.configuration.exception_handler.response.ErrorResponse;
import com.between.pricedemo.domain.exception.ResourceCreateException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ResourceCreateExceptionHandlerTest {

    @InjectMocks
    private ResourceCreateExceptionHandler handler;

    @Test
    void when_exception_is_thrown_then_internal_server_error_code_is_returned() {
        ResponseEntity<Object> response = this.handler.handleResourceCreateException(
                new ResourceCreateException("::message::")
        );

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(new ErrorResponse("Error creating brand"), response.getBody());
    }

}