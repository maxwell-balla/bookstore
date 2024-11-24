package com.maxwell.catalog_service.web.controllers;

import com.maxwell.catalog_service.domain.Product;
import com.maxwell.catalog_service.domain.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    Page<Product> getProducts(Pageable pageable) {
        log.info("Get products from catalog");
        return productService.getProducts(pageable);
    }

    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    Product getProductByCode(@PathVariable String code) {
        log.info("Received request to get product with code: {}", code);
        return productService.getProductByCode(code);
    }
}