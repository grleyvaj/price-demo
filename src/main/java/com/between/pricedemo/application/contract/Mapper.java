package com.between.pricedemo.application.contract;

public interface Mapper<From, To> {

    To map(From input);

}
