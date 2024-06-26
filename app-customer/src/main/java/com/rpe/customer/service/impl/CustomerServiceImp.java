package com.rpe.customer.service.impl;

import com.rpe.customer.domain.Customer;
import com.rpe.customer.domain.CustomerDetailResponse;
import com.rpe.customer.domain.CustomerRequest;
import com.rpe.customer.domain.CustomerResponse;
import com.rpe.customer.exception.NotFoundException;
import com.rpe.customer.mapper.CustomerMapper;
import com.rpe.customer.prox.AppCardProx;
import com.rpe.customer.repository.CustomerJapRepository;
import com.rpe.customer.service.CustomerService;
import com.rpe.customer.service.MessageService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class CustomerServiceImp implements CustomerService {
    private final CustomerJapRepository customerJapRepository;
    private final AppCardProx appCardProx;
    private final CustomerMapper customerMapper;
    private final MessageService messageService;

    public CustomerServiceImp(CustomerJapRepository customerJapRepository, AppCardProx appCardProx,
                              CustomerMapper customerMapper, MessageService messageService) {
        this.customerJapRepository = customerJapRepository;
        this.appCardProx = appCardProx;
        this.customerMapper = customerMapper;
        this.messageService = messageService;
    }

    @Override
    public CustomerResponse save(CustomerRequest customerRequest) {

        Customer customer = customerJapRepository.findById(customerRequest.id()).orElse(null);

        if (Objects.isNull(customer)) {
            customer = customerMapper.toCustomer(customerRequest);
            customer.setCreatedAt(LocalDateTime.now());
        }

        customer.setUpdatedAt(LocalDateTime.now());
        var save = customerJapRepository.save(customer);

        messageService.send(customerMapper.toCard(customerRequest.card()));

        return customerMapper.toCustomerResponse(save);
    }

    @Override
    public CustomerDetailResponse findById(Long id) {
        var customer = customerJapRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found"));
        var allCardAndProducts = appCardProx.findAllCardAndProductByCustomer(id);
        return new CustomerDetailResponse(
                customer.getName(),
                customer.getCpf(),
                customer.getStatus(),
                customer.getBirth(),
                allCardAndProducts
        );
    }
}
