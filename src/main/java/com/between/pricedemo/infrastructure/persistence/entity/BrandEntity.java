package com.between.pricedemo.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "brand")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_brand")
    @SequenceGenerator(name = "sequence_brand", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "country_code", nullable = false, length = 3)
    private String countryCode;

    @Column(name = "sector", length = 100)
    private String sector;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

}