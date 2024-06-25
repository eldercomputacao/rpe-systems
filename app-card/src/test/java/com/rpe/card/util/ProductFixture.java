package com.rpe.card.util;

import com.rpe.card.domain.ProductResponse;

import java.time.LocalDateTime;

public class ProductFixture {

    public static ProductResponse createProduct() {
        return new ProductResponse(
                1l,
                "description",
                "ATIVO",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
