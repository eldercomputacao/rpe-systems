package com.rpe.customer.domain;

import java.io.Serializable;

public record CustomerResponse(
        Long id,
        String name,
        String cpf,
        String status,
        String birth,
        String createdAt,
        String updatedAt
) implements Serializable {
}
