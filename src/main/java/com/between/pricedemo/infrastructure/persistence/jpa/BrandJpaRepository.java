package com.between.pricedemo.infrastructure.persistence.jpa;

import com.between.pricedemo.infrastructure.persistence.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandJpaRepository extends JpaRepository<BrandEntity, Long> {

}
