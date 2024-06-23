package com.rpe.products.service.impl;

import com.rpe.products.domain.Product;
import com.rpe.products.exception.NotFoundException;
import com.rpe.products.repository.ProductJapRepository;
import com.rpe.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductJapRepository productRepository;

    @Override
    public Product save(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    @Cacheable("products")
    public Product findById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
    }
}
