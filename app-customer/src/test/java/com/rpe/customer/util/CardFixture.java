package com.rpe.customer.util;

import com.rpe.customer.domain.Card;
import com.rpe.customer.domain.CardWithProductResponse;
import com.rpe.customer.domain.ProductResponse;

import java.time.LocalDateTime;

public class CardFixture {

    public static CardWithProductResponse createCustomerWithProduct() {
        return new CardWithProductResponse(
                1l, "1111",  "FULANO FULANO", "ATIVO",
                LocalDateTime.now().toString(),
                LocalDateTime.now().toString(),
                new ProductResponse(1l, "desc", "ATIVO",
                        LocalDateTime.now(),
                        LocalDateTime.now()));
    }

    public static Card createCard() {
        var card = new Card();
        card.setCustomerId(1l);
        card.setProductId(1l);
        card.setNumber("1111");
        card.setPassword("1111");
        card.setStatus("ATIVO");
        card.setPersonalizedName("FULANO FULANO");
        card.setCreatedAt(LocalDateTime.now().toString());
        card.setUpdatedAt(LocalDateTime.now().toString());
        return card;
    }
}
