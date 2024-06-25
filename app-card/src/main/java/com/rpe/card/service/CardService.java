package com.rpe.card.service;

import com.rpe.card.domain.CardWithProductResponse;

import java.util.List;

public interface CardService {
    List<CardWithProductResponse> findAllCardAndProductByCustomer(long id);
}
