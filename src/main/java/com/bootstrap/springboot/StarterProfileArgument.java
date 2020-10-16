package com.bootstrap.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

/**
 * A Simple Spring Boot bootstrap app
 *
 * @author Odilio Noronha Filho
 */
@EnableEncryptableProperties
@SpringBootApplication
public class StarterProfileArgument {

    public static void main(String[] args) {
    	SpringApplication.run(StarterProfileArgument.class, args);
    	
    }
    
}
