package com.rpe.card.util;

import com.rpe.card.domain.Card;
import com.rpe.card.domain.CardWithProductResponse;
import com.rpe.card.domain.ProductResponse;

import java.time.LocalDateTime;

public class CardFixture {

    public static Card createCard() {
        Card card = new Card();
        card.setId(1l);
        card.setProductId(1l);
        card.setCustomerId(1l);
        card.setNumber("1111");
        card.setPassword("1231");
        card.setStatus("ATIVO");
        card.setPersonalizedName("NOME NOME");
        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());
        return card;
    }

    public static CardWithProductResponse createCardWithProductResponse(long id) {
        return new CardWithProductResponse(
                id,
                "111111",
                "NAME NAME",
                "ATIVO",
                LocalDateTime.now().toString(),
                LocalDateTime.now().toString(),
                new ProductResponse(
                        (id * 10),
                        "description",
                        "ATIVO",
                        LocalDateTime.now(),
                        LocalDateTime.now()
                )
        );
    }
}
