package com.between.pricedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        scanBasePackages = {
                "com.between.pricedemo.application.bean",
                "com.between.pricedemo.application.configuration",
                "com.between.pricedemo.application.controller",
                "com.between.pricedemo.infrastructure.persistence"
        }
)
@EnableJpaRepositories
public class PriceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriceDemoApplication.class, args);
    }

}
