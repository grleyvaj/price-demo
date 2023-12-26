package com.between.pricedemo.infrastructure.persistence.specification;

import com.between.pricedemo.infrastructure.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface PriceJpaSpecificationExecutor extends JpaRepository<PriceEntity, Long>, JpaSpecificationExecutor<PriceEntity> {

}
