package com.maxwell.catalog_service.web.controllers;

import com.maxwell.catalog_service.domain.Product;
import com.maxwell.catalog_service.domain.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    Page<Product> getProducts(Pageable pageable) {
        return productService.getProducts(pageable);
    }
}
