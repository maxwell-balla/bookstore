package com.maxwell.catalog_service.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}
