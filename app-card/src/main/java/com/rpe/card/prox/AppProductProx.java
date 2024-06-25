package com.rpe.card.prox;

import com.rpe.card.domain.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "product", url = "${prox.product.url}")
public interface AppProductProx {

    @GetMapping("/products/{id}")
    ProductResponse findById(@PathVariable long id);
}
