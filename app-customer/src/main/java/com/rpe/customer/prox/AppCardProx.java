package com.rpe.customer.prox;

import com.rpe.customer.domain.CardWithProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "card", url = "${prox.card.url}")
public interface AppCardProx {

    @GetMapping("/cards/customerId/{id}")
    List<CardWithProductResponse> findAllCardAndProductByCustomer(@PathVariable long id);
}
