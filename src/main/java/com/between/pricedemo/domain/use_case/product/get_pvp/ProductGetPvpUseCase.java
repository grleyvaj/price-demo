package com.between.pricedemo.domain.use_case.product.get_pvp;

import com.between.pricedemo.domain.entity.MethodApply;
import com.between.pricedemo.domain.entity.Pvp;
import com.between.pricedemo.domain.exception.CannotAvailablePvpException;
import com.between.pricedemo.domain.repository.PriceRepository;
import com.between.pricedemo.domain.repository.PvpFilter;
import com.between.pricedemo.domain.use_case.validator.error.ErrorCode;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ProductGetPvpUseCase {

    private final PriceRepository priceRepository;
    private final MethodApply method;

    public Pvp execute(PvpFilter filter) throws CannotAvailablePvpException {
        Optional<Pvp> pvp = method == MethodApply.QUERY
                ? this.priceRepository.findByWithQuery(filter)
                : this.priceRepository.findByWithSpec(filter);

        return pvp.orElseThrow(() -> new CannotAvailablePvpException(ErrorCode.PVP_NOT_AVAILABLE.name()));
    }

}
