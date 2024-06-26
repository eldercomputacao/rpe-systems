package com.rpe.customer.util;

import com.rpe.customer.domain.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerFixture {

    public static Customer createCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("FULANO");
        customer.setCpf("111.111.111-11");
        customer.setBirth("1988-01-01");
        customer.setStatus("ATIVO");
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());
        return customer;
    }

    public static CustomerRequest createCustomerResquest() {
        return new CustomerRequest(
                1l,
                "FULANO",
                "111.111.111-11",
                "ATIVO",
                "1988-01-01",
                new CardRequest(
                        1l,
                        1l,
                        "11111",
                        "12345",
                        "FULANO FULANO",
                        "ATIVO"
                ));
    }

    public static CustomerResponse createCustomerResponse() {
        return new CustomerResponse(
                1l,
                "FULANO",
                "111.111.111-11",
                "ATIVO",
                "1988-01-01",
                LocalDateTime.now().toString(),
                LocalDateTime.now().toString());
    }

    public static CustomerDetailResponse createCustomerDetailResponse() {
        return new CustomerDetailResponse(
                "FULANO",
                "111.111.111-11",
                "ATIVO",
                "1988-01-01",
                new ArrayList<>(List.of(
                       new CardWithProductResponse(
                               1l,
                               "1111",
                               "FULANO NAME",
                               "ATIVO",
                               LocalDateTime.now().toString(),
                               LocalDateTime.now().toString(),
                               new ProductResponse(
                                       1l,
                                       "description",
                                       "ATIVO",
                                       LocalDateTime.now(),
                                       LocalDateTime.now()
                               )
                       )
                ))
        );
    }
}
