package com.between.pricedemo.application.bean;

import com.between.pricedemo.application.contract.Mapper;
import com.between.pricedemo.domain.entity.Brand;
import com.between.pricedemo.domain.entity.Pvp;
import com.between.pricedemo.domain.repository.BrandCreateInput;
import com.between.pricedemo.domain.repository.BrandRepository;
import com.between.pricedemo.domain.repository.PriceRepository;
import com.between.pricedemo.domain.repository.ProductRepository;
import com.between.pricedemo.infrastructure.persistence.entity.BrandEntity;
import com.between.pricedemo.infrastructure.persistence.entity.PriceEntity;
import com.between.pricedemo.infrastructure.persistence.entity.PriceProjection;
import com.between.pricedemo.infrastructure.persistence.jpa.BrandJpaRepository;
import com.between.pricedemo.infrastructure.persistence.jpa.PriceJpaRepository;
import com.between.pricedemo.infrastructure.persistence.jpa.ProductJpaRepository;
import com.between.pricedemo.infrastructure.persistence.specification.PriceJpaSpecificationExecutor;
import com.between.pricedemo.infrastructure.repository.JpaBrandRepository;
import com.between.pricedemo.infrastructure.repository.JpaPriceRepository;
import com.between.pricedemo.infrastructure.repository.JpaProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Repositories {

    @Bean
    public BrandRepository jpaBrandRepository(
            BrandJpaRepository brandJpaRepository,
            Mapper<BrandCreateInput, BrandEntity> brandEntityMapper,
            Mapper<BrandEntity, Brand> brandMapper
    ) {
        return new JpaBrandRepository(brandJpaRepository, brandEntityMapper, brandMapper);
    }

    @Bean
    public ProductRepository productRepository(ProductJpaRepository productJpaRepository) {
        return new JpaProductRepository(productJpaRepository);
    }

    @Bean
    public PriceRepository priceRepository(
            PriceJpaRepository priceJpaRepository,
            PriceJpaSpecificationExecutor priceSpecificationExecutor,
            Mapper<PriceProjection, Pvp> projectionPvpMapper,
            Mapper<PriceEntity, Pvp> pvpMapper
    ) {
        return new JpaPriceRepository(
                priceJpaRepository,
                priceSpecificationExecutor,
                projectionPvpMapper,
                pvpMapper
        );
    }


}
