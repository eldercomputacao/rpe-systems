package com.rpe.products.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rpe.products.domain.Product;
import com.rpe.products.domain.ProductRequest;
import com.rpe.products.mapper.ProductMapper;
import com.rpe.products.service.ProductService;
import com.rpe.products.util.ProductFixture;
import org.junit.jupiter.api.BeforeEach;
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
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductMapper productMapper;

    @MockBean
    private ProductService productService;

    Product product;

    @BeforeEach
    public void setup() {
        product = ProductFixture.createProduct();
    }

    @Test
    void save_ReturnsProduct_WhenSuccessfullySaved() throws Exception {

        given(productMapper.toProduct(any(ProductRequest.class)))
                .willReturn(product);
        given(productService.save(any(Product.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ProductFixture.createProductRequest())));

        response.andExpect(status().isCreated())
                .andDo(print())
                .andExpect(jsonPath("$.description", is(product.getDescription())));
    }

    @Test
    void findById_ReturnsProduct_WhenSuccessfullyFound() throws Exception {

        long productId = 1l;
        given(productService.findById(productId))
                .willReturn(product);

        ResultActions response = mockMvc.perform(get("/products/{id}", productId)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.description", is(product.getDescription())));
    }
}