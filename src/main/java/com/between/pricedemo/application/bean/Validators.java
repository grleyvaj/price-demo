package com.between.pricedemo.application.bean;

import com.between.pricedemo.application.validator.BrandExistValidator;
import com.between.pricedemo.application.validator.ProductExistValidator;
import com.between.pricedemo.domain.repository.BrandRepository;
import com.between.pricedemo.domain.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class Validators {

    @Bean
    public BrandExistValidator brandExistValidator(BrandRepository brandRepository) {
        return new BrandExistValidator(brandRepository);
    }

    @Bean
    public ProductExistValidator productExistValidator(ProductRepository productRepository) {
        return new ProductExistValidator(productRepository);
    }

}
