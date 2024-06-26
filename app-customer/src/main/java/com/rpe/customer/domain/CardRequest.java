package com.rpe.customer.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record CardRequest(
        @NotNull(message = "The field 'customerId' must not null")
        Long customerId,
        @NotNull(message = "The field 'productId' must not null")
        Long productId,
        @NotBlank(message = "The field 'number' must not be empty")
        String number,
        @NotBlank(message = "The field 'password' must not be empty")
        String password,
        @NotBlank(message = "The field 'personalizedName' must not be empty")
        String personalizedName,
        @NotBlank(message = "The field 'status' must not be empty")
        String status
) implements Serializable {
}
