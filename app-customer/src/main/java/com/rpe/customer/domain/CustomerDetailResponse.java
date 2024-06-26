package com.rpe.customer.domain;

import java.io.Serializable;
import java.util.List;

public record CustomerDetailResponse(
        String name,
        String cpf,
        String status,
        String birth,
        List<CardWithProductResponse> cards
) implements Serializable {
}
