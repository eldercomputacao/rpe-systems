package com.rpe.customer.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record CustomerRequest(
        @NotNull(message = "The field 'id' must not null")
        Long id,
        @NotBlank(message = "The field 'name' must not be empty")
        String name,
        @NotBlank(message = "The field 'cpf' must not be empty")
        String cpf,
        @NotBlank(message = "The field 'status' must not be empty")
        String status,
        @NotBlank(message = "The field 'birth' must not be empty")
        String birth,
        @NotNull(message = "The field 'card' must not null")
        CardRequest card
) implements Serializable {
}
