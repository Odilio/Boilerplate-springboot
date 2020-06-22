package com.bootstrap;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import com.bootstrap.springboot.Starter;
import com.bootstrap.springboot.model.Product;
import com.bootstrap.springboot.repository.ProductRepository;

@ContextConfiguration(classes=Starter.class)
@EnableAutoConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestAssuredTest {

	@MockBean
    private ProductRepository productRepository;

    @LocalServerPort
    private int port;

    @Test
    public void shouldReturnHelloWorld() throws Exception {
        when()
                .get(String.format("http://localhost:%s/hello", port))
                .then()
                .statusCode(is(200))
                .body(containsString("Hello World!"));
    }

    @Test
    public void shouldReturnProduct() throws Exception {
    	 Long number = 1l;
         Optional<Product> product = Optional.of(new Product(number, "Pan"));
    	 productRepository.save(product.get());

        when()
                .get(String.format("http://localhost:%s/product/1", port))
                .then()
                .statusCode(is(200))
                .body("id", equalTo(1));
    }
}