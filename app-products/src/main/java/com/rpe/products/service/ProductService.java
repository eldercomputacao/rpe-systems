package com.rpe.products.service;


import com.rpe.products.domain.Product;

public interface ProductService {

    Product save(Product product);
    Product findById(long id);
}
