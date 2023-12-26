package com.between.pricedemo.infrastructure.persistence.jpa;

import com.between.pricedemo.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

}
