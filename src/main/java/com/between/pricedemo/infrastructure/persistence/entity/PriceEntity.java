package com.between.pricedemo.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "price")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_price")
    @SequenceGenerator(name = "sequence_price", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "priority", nullable = false)
    private Integer priority;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "currency", length = 3, nullable = false)
    private String currency;

}