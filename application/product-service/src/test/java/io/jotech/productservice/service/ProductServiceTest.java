package io.jotech.productservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import io.jotech.productservice.repository.ProductRepository;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class ProductServiceTest {
    @Container
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:latest");

    @Autowired
    private MockMvc mockMvc;

    @Autowired

    private ProductRepository productRepository;


    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
    }

/*
    @Test
    void createProduct() throws Exception {
        var productString = """
                    {
                      "name": "john",
                      "description": "oenga",
                      "price": 82.60
                    }
                """;

        mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(productString))
                )
                .andExpect(status().isCreated());
        Assertions.assertEquals(1,productRepository.findAll().size())  ;

    }
*/

    @Test
    void getAllProducts() {
    }
}