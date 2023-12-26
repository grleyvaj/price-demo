package com.between.pricedemo.application.bean;

import com.between.pricedemo.application.configuration.exception_handler.response.ValidationErrorResponseCreator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class Utils {

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    public ValidationErrorResponseCreator validationErrorResponseCreator(MessageSource messageSource) {
        return new ValidationErrorResponseCreator(messageSource);
    }

}


