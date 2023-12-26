package com.between.pricedemo.application.bean;

import com.between.pricedemo.application.contract.Mapper;
import com.between.pricedemo.application.controller.brand.create.request.BrandCreateInputMapper;
import com.between.pricedemo.application.controller.brand.create.request.BrandCreateRequest;
import com.between.pricedemo.application.controller.brand.create.response.BrandCreateResponse;
import com.between.pricedemo.application.controller.brand.create.response.BrandCreateResponseMapper;
import com.between.pricedemo.application.controller.product.get_pvp.response.PriceDetailResponse;
import com.between.pricedemo.application.controller.product.get_pvp.response.PriceDetailResponseMapper;
import com.between.pricedemo.domain.entity.Brand;
import com.between.pricedemo.domain.entity.Pvp;
import com.between.pricedemo.domain.repository.BrandCreateInput;
import com.between.pricedemo.infrastructure.persistence.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class Helpers {

    @Bean
    public Mapper<BrandCreateInput, BrandEntity> brandEntityMapper(Clock clock) {
        return new BrandEntityMapper(clock);
    }

    @Bean
    public Mapper<BrandEntity, Brand> brandMapper() {
        return new BrandMapper();
    }

    @Bean
    public Mapper<BrandCreateRequest, BrandCreateInput> brandCreateInputMapper() {
        return new BrandCreateInputMapper();
    }

    @Bean
    public Mapper<Brand, BrandCreateResponse> brandCreateResponseMapper() {
        return new BrandCreateResponseMapper();
    }

    @Bean
    public Mapper<PriceProjection, Pvp> priceProjectionToPvpMapper() {
        return new PriceProjectionToPvpMapper();
    }

    @Bean
    public Mapper<PriceEntity, Pvp> pvpMapper() {
        return new PriceEntityToPvpMapper();
    }

    @Bean
    public Mapper<Pvp, PriceDetailResponse> pvpPriceDetailResponseMapper() {
        return new PriceDetailResponseMapper();
    }

}
