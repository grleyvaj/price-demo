package com.between.pricedemo.application.controller.brand;

import com.between.pricedemo.application.controller.brand.create.request.BrandCreateRequest;
import com.between.pricedemo.application.controller.brand.create.response.BrandCreateResponse;
import com.between.pricedemo.application.contract.Mapper;
import com.between.pricedemo.domain.entity.Brand;
import com.between.pricedemo.domain.exception.ResourceCreateException;
import com.between.pricedemo.domain.repository.BrandCreateInput;
import com.between.pricedemo.domain.use_case.brand.create.BrandCreateUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/brands")
public class BrandsApiController implements BrandsApi {

    private final BrandCreateUseCase brandCreateUseCase;
    private final Mapper<BrandCreateRequest, BrandCreateInput> createInputMapper;
    private final Mapper<Brand, BrandCreateResponse> createResponseMapper;

    @Override
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BrandCreateResponse> create(
            @RequestBody @Valid BrandCreateRequest request
    ) throws ResourceCreateException {
        Brand brand = this.brandCreateUseCase.execute(this.createInputMapper.map(request));

        return ResponseEntity.ok(this.createResponseMapper.map(brand));
    }

}
