package com.rpe.card.controller;

import com.rpe.card.domain.CardWithProductResponse;
import com.rpe.card.service.CardService;
import com.rpe.card.util.CardFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CardControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardService cardService;

    CardWithProductResponse cardWithProductResponse;

    @BeforeEach
    public void setup() {
        cardWithProductResponse = CardFixture.createCardWithProductResponse(1);
    }

    @Test
    void findAllCardAndProductByCustomer_ReturnsListCardWithProducts_WhenSuccessfullyList() throws Exception {
        given(cardService.findAllCardAndProductByCustomer(any(Long.class)))
                .willReturn(new ArrayList<>(List.of(cardWithProductResponse)));

        ResultActions response = mockMvc.perform(get("/cards/customerId/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk());
    }
}