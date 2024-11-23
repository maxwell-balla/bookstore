package com.maxwell.catalog_service.domain;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface ProductMapper {
    Product toProduct(ProductEntity productEntity);
}