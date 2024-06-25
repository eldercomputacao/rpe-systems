package com.rpe.card.service;

import com.rpe.card.domain.Card;
import com.rpe.card.domain.CardWithProductResponse;
import com.rpe.card.domain.ProductResponse;
import com.rpe.card.prox.AppProductProx;
import com.rpe.card.repository.CardJapRepository;
import com.rpe.card.service.impl.CardServiceImp;
import com.rpe.card.util.CardFixture;
import com.rpe.card.util.ProductFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CardServiceTest {
    @Mock
    private CardJapRepository cardJapRepository;

    @Mock
    private AppProductProx appProductProx;

    @InjectMocks
    private CardServiceImp cardService;

    CardWithProductResponse cardWithProductResponse;
    Card card;
    ProductResponse productResponse;

    @BeforeEach
    public void setup() {
        cardWithProductResponse = CardFixture.createCardWithProductResponse(1);
        card = CardFixture.createCard();
        productResponse = ProductFixture.createProduct();
    }

    @Test
    void findById_ReturnsProduct_WhenSuccessfullyFound() {

        given(cardJapRepository.findByCustomerIdEquals(any(Long.class)))
                .willReturn(new ArrayList<>(List.of(card)));
        given(appProductProx.findById(any(Long.class)))
                .willReturn(productResponse);

        var found = cardService.findAllCardAndProductByCustomer(1l);
        assertNotNull(found);
        assertEquals(1, found.size());
    }
}