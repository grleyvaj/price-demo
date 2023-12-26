package com.between.pricedemo.infrastructure.repository;

import com.between.pricedemo.application.contract.Mapper;
import com.between.pricedemo.domain.entity.Brand;
import com.between.pricedemo.domain.exception.ResourceCreateException;
import com.between.pricedemo.domain.repository.BrandCreateInput;
import com.between.pricedemo.domain.repository.BrandRepository;
import com.between.pricedemo.infrastructure.persistence.entity.BrandEntity;
import com.between.pricedemo.infrastructure.persistence.jpa.BrandJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaBrandRepository implements BrandRepository {

    private final BrandJpaRepository brandJpaRepository;
    private final Mapper<BrandCreateInput, BrandEntity> brandEntityMapper;
    private final Mapper<BrandEntity, Brand> brandMapper;

    @Override
    public Brand create(BrandCreateInput input) throws ResourceCreateException {
        try {
            BrandEntity createdBrand = this.brandJpaRepository.save(this.brandEntityMapper.map(input));
            return this.brandMapper.map(createdBrand);
        } catch (Exception exc) {
            throw new ResourceCreateException(exc);
        }
    }

    @Override
    public boolean exist(Long brandId) {
        return this.brandJpaRepository.existsById(brandId);
    }

}
