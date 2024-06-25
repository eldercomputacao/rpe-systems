package com.rpe.card.service.impl;

import com.rpe.card.domain.Card;
import com.rpe.card.domain.CardWithProductResponse;
import com.rpe.card.prox.AppProductProx;
import com.rpe.card.repository.CardJapRepository;
import com.rpe.card.service.CardService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class CardServiceImp implements CardService {
    private final AppProductProx appProductProx;
    private final CardJapRepository cardJapRepository;

    public CardServiceImp(AppProductProx appProductProx, CardJapRepository cardJapRepository) {
        this.appProductProx = appProductProx;
        this.cardJapRepository = cardJapRepository;
    }

    @Override
    public List<CardWithProductResponse> findAllCardAndProductByCustomer(long id) {
        var cards = cardJapRepository.findByCustomerIdEquals(id);
        var cardWithProductList = cards.stream().map(this::getCardWithProduct).toList();
        return cardWithProductList;

    }

    private CardWithProductResponse getCardWithProduct(Card card) {
        var product = appProductProx.findById(card.getId());
        return new CardWithProductResponse(
                card.getCustomerId(),
                card.getNumber(),
                card.getPersonalizedName(),
                card.getStatus(),
                getDateString(card.getCreatedAt()),
                getDateString(card.getUpdatedAt()),
                product
        );
    }

    private String getDateString(LocalDateTime date) {
        return Objects.nonNull(date) ? date.toString() : null;
    }

}
