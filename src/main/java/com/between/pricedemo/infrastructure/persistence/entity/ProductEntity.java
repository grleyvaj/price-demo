package com.between.pricedemo.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_product")
    @SequenceGenerator(name = "sequence_product", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

}