package com.rpe.card.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ProductResponse(
        Long id,
        String description,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) implements Serializable {
}
