package com.maxwell.catalog_service.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String code;
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
}
