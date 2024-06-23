package com.rpe.products.controller;

import com.rpe.products.domain.Product;
import com.rpe.products.domain.ProductRequest;
import com.rpe.products.mapper.ProductMapper;
import com.rpe.products.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<Product> save(@Valid @RequestBody ProductRequest productRequest) {
        var product = productMapper.toProduct(productRequest);
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }
}
