package com.rpe.products.repository;

import com.rpe.products.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJapRepository extends JpaRepository<Product, Long> {
}
