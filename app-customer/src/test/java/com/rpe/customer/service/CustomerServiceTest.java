package com.rpe.customer.service;

import com.rpe.customer.exception.NotFoundException;
import com.rpe.customer.mapper.CustomerMapper;
import com.rpe.customer.prox.AppCardProx;
import com.rpe.customer.repository.CustomerJapRepository;
import com.rpe.customer.service.impl.CustomerServiceImp;
import com.rpe.customer.util.CardFixture;
import com.rpe.customer.util.CustomerFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerJapRepository customerJapRepository;
    @Mock
    private AppCardProx appCardProx;
    @Mock
    private CustomerMapper customerMapper;
    @Mock
    private MessageService messageService;

    @InjectMocks
    private CustomerServiceImp customerService;

    @Test
    void save_ReturnsCustomerResponse_WhenSuccessfullySaved() {

        var customer = CustomerFixture.createCustomer();
        given(customerJapRepository.findById(any(Long.class))).willReturn(Optional.of(customer));

        given(customerJapRepository.save(any()))
                .willAnswer((invocation) -> invocation.getArgument(0));

        var card = CardFixture.createCard();
        given(customerMapper.toCard(any())).willReturn(card);

        var customerResponse = CustomerFixture.createCustomerResponse();
        given(customerMapper.toCustomerResponse(customer)).willReturn(customerResponse);

        doNothing().when(messageService).send(any());

        var customerRequest = CustomerFixture.createCustomerResquest();
        var save = customerService.save(customerRequest);

        assertNotNull(save);
    }

    @Test
    void findById_ReturnsCustomerDetailResponse_WhenSuccessfullyFound() {
        var customer = CustomerFixture.createCustomer();
        var card = CardFixture.createCustomerWithProduct();

        given(customerJapRepository.findById(any(Long.class)))
                .willReturn(Optional.of(customer));

        given(appCardProx.findAllCardAndProductByCustomer(any(Long.class)))
                .willReturn(new ArrayList<>(List.of(card)));

        var found = customerService.findById(customer.getId());
        assertNotNull(found);
        assertEquals(customer.getName(), found.name());
    }

    @Test
    void findById_ReturnsNotFoundException_WhenNotFound() {
        given(customerJapRepository.findById(any(Long.class)))
                .willReturn(Optional.empty());

        var notFoundException = assertThrows(NotFoundException.class, () -> {
            customerService.findById(1l);
        });

        assertNotNull(notFoundException);
    }
}