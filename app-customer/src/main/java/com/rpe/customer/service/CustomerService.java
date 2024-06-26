package com.rpe.customer.service;

import com.rpe.customer.domain.CustomerDetailResponse;
import com.rpe.customer.domain.CustomerRequest;
import com.rpe.customer.domain.CustomerResponse;

public interface CustomerService {

    CustomerResponse save(CustomerRequest customerRequest);

    CustomerDetailResponse findById(Long id);
}

