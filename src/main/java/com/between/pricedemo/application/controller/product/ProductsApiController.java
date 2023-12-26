package com.between.pricedemo.application.controller.product;

import com.between.pricedemo.application.contract.Mapper;
import com.between.pricedemo.application.controller.product.get_pvp.response.PriceDetailResponse;
import com.between.pricedemo.application.validator.BrandExist;
import com.between.pricedemo.application.validator.ProductExist;
import com.between.pricedemo.domain.entity.Pvp;
import com.between.pricedemo.domain.exception.CannotAvailablePvpException;
import com.between.pricedemo.domain.repository.PvpFilter;
import com.between.pricedemo.domain.use_case.product.get_pvp.ProductGetPvpUseCase;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
@Validated
public class ProductsApiController implements ProductsApi {

    private final ProductGetPvpUseCase productGetPvpUseCase;
    private final Mapper<Pvp, PriceDetailResponse> pvpPriceDetailResponseMapper;

    @Override
    @GetMapping(value = "/{productId}/brands/{brandId}/pvp", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceDetailResponse> get_pvp(
            @PathVariable(value = "productId") @ProductExist(message = "product.notFound") Long productId,
            @PathVariable(value = "brandId") @BrandExist(message = "brand.notFound") Long brandId,
            @RequestParam(value = "applicationDate", required = false) @NotNull(message = "brand.applicationDate.null") LocalDateTime applicationDate
    ) throws CannotAvailablePvpException {
        Pvp pvp = this.productGetPvpUseCase.execute(
                new PvpFilter(productId, brandId, applicationDate)
        );

        return ResponseEntity.ok(this.pvpPriceDetailResponseMapper.map(pvp));
    }

}
