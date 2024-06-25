package com.rpe.products.repository;

import com.rpe.products.domain.Product;
import com.rpe.products.util.ProductFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductJapRepositoryTest {

    @Autowired
    private ProductJapRepository productRepository;

    Product product;

    @BeforeEach
    public void setup() {
        product = ProductFixture.createProduct();
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
    }

    @Test
    void save_ReturnsProduct_WhenSuccessfullySaved() {

        Product save = productRepository.save(product);

        assertNotNull(save);
        assertNotNull(save.getId());
        assertNotNull(save.getCreatedAt());
        assertNotNull(save.getUpdatedAt());
        assertEquals(product.getDescription(), save.getDescription());
    }

    @Test
    void findById_ReturnsProduct_WhenSuccessfullyFound() {

        productRepository.save(product);
        Optional<Product> productOptional = productRepository.findById(product.getId());

        assertTrue(productOptional.isPresent());

        var product = productOptional.get();
        assertNotNull(product);
        assertNotNull(product.getId());
        assertNotNull(product.getCreatedAt());
        assertNotNull(product.getUpdatedAt());
    }

    @Test
    void findById_ReturnsEmpty_WhenNotFound() {
        Long productId = 22l;
        Optional<Product> productOptional = productRepository.findById(productId);

        assertTrue(productOptional.isEmpty());
    }

}