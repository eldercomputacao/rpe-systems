package com.rpe.products.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record ProductRequest(
        @NotBlank(message = "The field 'description' must not be empty")
        String description,
        @NotNull(message = "The field 'status' must not null")
        ProductStatus status
) implements Serializable {
}
