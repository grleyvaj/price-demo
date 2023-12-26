package com.between.pricedemo.domain.repository;

import com.between.pricedemo.domain.entity.Pvp;

import java.util.Optional;

public interface PriceRepository {

    Optional<Pvp> findByWithQuery(PvpFilter filter);

    Optional<Pvp> findByWithSpec(PvpFilter filter);

    boolean exist(Long priceId);

}
