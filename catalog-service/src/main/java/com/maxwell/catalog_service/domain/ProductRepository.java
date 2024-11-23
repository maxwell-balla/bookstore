package com.maxwell.catalog_service.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}
