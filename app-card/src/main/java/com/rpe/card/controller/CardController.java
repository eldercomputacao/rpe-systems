package com.rpe.card.controller;

import com.rpe.card.domain.CardWithProductResponse;
import com.rpe.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/customerId/{id}")
    public ResponseEntity<List<CardWithProductResponse>> findAllCardAndProductByCustomer(@PathVariable long id) {
        return new ResponseEntity<>(cardService.findAllCardAndProductByCustomer(id), HttpStatus.OK);
    }
}
