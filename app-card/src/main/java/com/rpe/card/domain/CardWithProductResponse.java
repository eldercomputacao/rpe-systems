package com.rpe.card.domain;

import java.io.Serializable;

public record CardWithProductResponse(
        Long customerId,
        String number,
        String personalizedName,
        String status,
        String createdAt,
        String updatedAt,
        ProductResponse product
) implements Serializable {
}
