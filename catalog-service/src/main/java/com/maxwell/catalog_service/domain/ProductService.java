package com.maxwell.catalog_service.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Page<Product> getProducts(Pageable pageable) {
        log.info("Get products");
        return productRepository.findAll(pageable)
                .map(productMapper::toProduct);
    }

    public Product getProductByCode(String code) {
        log.info("Searching product with code: {}", code);
        return productMapper.toProduct(productRepository.findByCode(code)
                .orElseThrow(() -> ProductNotFoundException.forCode(code)));
    }
}