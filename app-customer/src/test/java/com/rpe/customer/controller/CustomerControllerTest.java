package com.rpe.customer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rpe.customer.service.CustomerService;
import com.rpe.customer.util.CustomerFixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;

    @Test
    void save_ReturnsProduct_WhenSuccessfullySaved() throws Exception {

        var customerResponse = CustomerFixture.createCustomerResponse();
        var customerResquest = CustomerFixture.createCustomerResquest();
        given(customerService.save(any())).willReturn(customerResponse);

        ResultActions response = mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerResquest)));

        response.andExpect(status().isCreated())
                .andDo(print())
                .andExpect(jsonPath("$.cpf", is(customerResponse.cpf())));
    }

    @Test
    void findById_ReturnsCustomerDetailResponse_WhenSuccessfullyFound() throws Exception {

        long productId = 1l;
        var customerDetailResponse = CustomerFixture.createCustomerDetailResponse();
        given(customerService.findById(productId))
                .willReturn(customerDetailResponse);

        ResultActions response = mockMvc.perform(get("/customers/{id}", productId)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.cpf", is(customerDetailResponse.cpf())))
                .andExpect(jsonPath("$.cards.size()", is(1)));
    }
}