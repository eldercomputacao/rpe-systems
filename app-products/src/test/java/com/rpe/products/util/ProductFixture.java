package com.rpe.products.util;

import com.rpe.products.domain.Product;
import com.rpe.products.domain.ProductRequest;
import com.rpe.products.domain.ProductStatus;

public class ProductFixture {
    public static Product createProduct() {
        Product product = new Product();
        product.setId(1l);
        product.setDescription("description");
        product.setStatus("ATIVO");
        return product;
    }

    public static ProductRequest createProductRequest() {
        return new ProductRequest("description", ProductStatus.ATIVO);
    }
}
