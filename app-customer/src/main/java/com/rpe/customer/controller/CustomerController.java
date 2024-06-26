package com.rpe.customer.controller;

import com.rpe.customer.domain.CustomerDetailResponse;
import com.rpe.customer.domain.CustomerRequest;
import com.rpe.customer.domain.CustomerResponse;
import com.rpe.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping()
    public ResponseEntity<CustomerResponse> save(@Valid @RequestBody CustomerRequest request) {
        return new ResponseEntity<>(customerService.save(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetailResponse> findById(@PathVariable long id) {
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }
}
