package com.bootstrap.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * A Simple Spring Boot bootstrap app
 *
 * @author Odilio Noronha Filho
 */
@SpringBootApplication
public class Starter {

    public static void main(String[] args) {
    	new SpringApplicationBuilder(Starter.class)
        .profiles("dev")
        .run(args);
    }
}
