package com.between.pricedemo.infrastructure.repository;

import com.between.pricedemo.application.contract.Mapper;
import com.between.pricedemo.domain.entity.Pvp;
import com.between.pricedemo.domain.repository.PriceRepository;
import com.between.pricedemo.domain.repository.PvpFilter;
import com.between.pricedemo.infrastructure.persistence.entity.PriceEntity;
import com.between.pricedemo.infrastructure.persistence.entity.PriceProjection;
import com.between.pricedemo.infrastructure.persistence.jpa.PriceJpaRepository;
import com.between.pricedemo.infrastructure.persistence.specification.PriceJpaSpecificationExecutor;
import com.between.pricedemo.infrastructure.persistence.specification.PriceSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaPriceRepository implements PriceRepository {

    private final PriceJpaRepository priceJpaRepository;
    private final PriceJpaSpecificationExecutor priceSpecificationExecutor;
    private final Mapper<PriceProjection, Pvp> priceProjectionToPvpMapper;
    private final Mapper<PriceEntity, Pvp> pvpMapper;

    @Override
    public Optional<Pvp> findByWithQuery(PvpFilter filter) {
        return this.priceJpaRepository.findPriceInfo(
                filter.getProductId(),
                filter.getBrandId(),
                filter.getApplicationDate()
        ).map(this.priceProjectionToPvpMapper::map);
    }

    @Override
    public Optional<Pvp> findByWithSpec(PvpFilter filter) {
        Specification<PriceEntity> specificationFilter = Specification
                .where(PriceSpecification.filterByProductIdAndBrandIdAndApplicationDate(
                        filter.getProductId(),
                        filter.getBrandId(),
                        filter.getApplicationDate()
                ))
                .and(PriceSpecification.orderByPriorityDesc());

        return this.priceSpecificationExecutor
                .findAll(specificationFilter)
                .stream().findFirst()
                .map(this.pvpMapper::map);
    }

    @Override
    public boolean exist(Long priceId) {
        return this.priceJpaRepository.existsById(priceId);
    }

}
