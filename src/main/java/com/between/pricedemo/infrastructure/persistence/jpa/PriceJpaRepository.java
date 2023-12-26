package com.between.pricedemo.infrastructure.persistence.jpa;

import com.between.pricedemo.infrastructure.persistence.entity.PriceEntity;
import com.between.pricedemo.infrastructure.persistence.entity.PriceProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p.productId AS productId, p.brandId AS brandId, p.id AS id, " +
            "p.startDate AS startDate, p.endDate AS endDate, p.price AS price " +
            "FROM PriceEntity p " +
            "WHERE p.productId = :productId AND p.brandId = :brandId AND :applicationDate BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC " +
            "LIMIT 1")
    Optional<PriceProjection> findPriceInfo(
            @Param("productId") Long productId,
            @Param("brandId") Long brandId,
            @Param("applicationDate") LocalDateTime applicationDate);

}
