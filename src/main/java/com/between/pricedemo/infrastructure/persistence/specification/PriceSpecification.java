package com.between.pricedemo.infrastructure.persistence.specification;

import com.between.pricedemo.infrastructure.persistence.entity.PriceEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public abstract class PriceSpecification {

    public static Specification<PriceEntity> filterByProductIdAndBrandIdAndApplicationDate(
            Long productId,
            Long brandId,
            LocalDateTime applicationDate
    ) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.and(
                criteriaBuilder.equal(root.get("productId"), productId),
                criteriaBuilder.equal(root.get("brandId"), brandId),
                criteriaBuilder.lessThanOrEqualTo(root.get("startDate"), applicationDate),
                criteriaBuilder.greaterThanOrEqualTo(root.get("endDate"), applicationDate)
        );
    }

    public static Specification<PriceEntity> orderByPriorityDesc() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.desc(root.get("priority")));
            return criteriaBuilder.conjunction();
        };
    }

}
