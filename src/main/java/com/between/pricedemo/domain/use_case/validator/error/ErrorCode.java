package com.between.pricedemo.domain.use_case.validator.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    PVP_NOT_AVAILABLE("PVP_NOT_AVAILABLE");

    private final String code;

}
