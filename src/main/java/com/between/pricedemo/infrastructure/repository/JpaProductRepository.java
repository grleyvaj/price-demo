package com.between.pricedemo.infrastructure.repository;

import com.between.pricedemo.domain.repository.ProductRepository;
import com.between.pricedemo.infrastructure.persistence.jpa.ProductJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaProductRepository implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public boolean exist(Long productId) {
        return this.productJpaRepository.existsById(productId);
    }

}
