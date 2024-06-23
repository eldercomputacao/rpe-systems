package com.rpe.products.service;

import com.rpe.products.exception.NotFoundException;
import com.rpe.products.repository.ProductJapRepository;
import com.rpe.products.service.impl.ProductServiceImp;
import com.rpe.products.util.ProductFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductJapRepository productJapRepository;

    @InjectMocks
    private ProductServiceImp productService;

    @Test
    void save_ReturnsProductWithDates_WhenSuccessfullySaved() {
        var product = ProductFixture.createProduct();
        given(productJapRepository.save(any())).willReturn(product);

        var save = productService.save(product);

        assertNotNull(save);
        assertNotNull(save.getCreatedAt());
        assertNotNull(save.getUpdatedAt());
        assertEquals(product.getId(), save.getId());
    }

    @Test
    void findById_ReturnsProduct_WhenSuccessfullyFound() {
        var product = ProductFixture.createProduct();
        given(productJapRepository.findById(any()))
                .willReturn(Optional.of(product));

        var found = productService.findById(product.getId());
        assertNotNull(found);
        assertEquals(product.getId(), found.getId());
    }

    @Test
    void findById_ReturnsNotFoundException_WhenNotFound() {
        given(productJapRepository.findById(any()))
                .willReturn(Optional.empty());

        var notFoundException = assertThrows(NotFoundException.class, () -> {
            productService.findById(1);
        });

        assertNotNull(notFoundException);
    }
}