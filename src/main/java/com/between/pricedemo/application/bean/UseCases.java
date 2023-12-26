package com.between.pricedemo.application.bean;

import com.between.pricedemo.domain.entity.MethodApply;
import com.between.pricedemo.domain.repository.BrandRepository;
import com.between.pricedemo.domain.repository.PriceRepository;
import com.between.pricedemo.domain.use_case.brand.create.BrandCreateUseCase;
import com.between.pricedemo.domain.use_case.product.get_pvp.ProductGetPvpUseCase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCases {

    @Bean
    public BrandCreateUseCase brandCreateUseCase(BrandRepository brandRepository) {
        return new BrandCreateUseCase(brandRepository);
    }

    @Bean
    public ProductGetPvpUseCase productGetPvpUseCase(
            PriceRepository priceRepository,
            @Value("${filer.method.apply}") String method
    ) {
        return new ProductGetPvpUseCase(priceRepository, MethodApply.valueOf(method));
    }

}
