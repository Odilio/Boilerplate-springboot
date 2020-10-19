package com.bootstrap.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Component;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

/**
 * A Simple Spring Boot bootstrap app
 *
 * @author Odilio Noronha Filho
 */
@EnableEncryptableProperties
@SpringBootApplication
public class Starter {

    public static void main(String[] args) {
    	new SpringApplicationBuilder(Starter.class)
        .profiles("dev")
        .run(args);
    }
    
   /* @Component
    public class MyRunner implements CommandLineRunner {
     
      @Value("${myProperty}")
      private String myProperty;

      @Override
      public void run(String... args) throws Exception {
        System.out.println("My property is = " + myProperty);
      }
     
    }*/
}
