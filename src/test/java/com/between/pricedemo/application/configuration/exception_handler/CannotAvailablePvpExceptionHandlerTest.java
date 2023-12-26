package com.between.pricedemo.application.configuration.exception_handler;

import com.between.pricedemo.application.configuration.exception_handler.response.ErrorResponse;
import com.between.pricedemo.domain.exception.CannotAvailablePvpException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CannotAvailablePvpExceptionHandlerTest {

    @InjectMocks
    private CannotAvailablePvpExceptionHandler handler;

    @Test
    void when_exception_is_thrown_then_internal_server_error_code_is_returned() {
        ResponseEntity<Object> response = this.handler.handleAvailablePvp(
                new CannotAvailablePvpException("::message::")
        );

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(new ErrorResponse("::message::"), response.getBody());
    }

}