package com.bootstrap;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.bootstrap.springboot.Starter;
import com.bootstrap.springboot.model.Product;
import com.bootstrap.springboot.repository.ProductRepository;

@ContextConfiguration(classes=Starter.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ControllerAPITest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;


    @Test
    public void shouldReturnHelloWorld() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(content().string("Hello World!"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void shouldReturnNameProduct() throws Exception {
    	Long number = 1l;
        Optional<Product> product = Optional.of(new Product(number, "Pan"));
        given(productRepository.findById(number)).willReturn(product);

        mockMvc.perform(get("/product/1"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(status().is2xxSuccessful());
    }

}