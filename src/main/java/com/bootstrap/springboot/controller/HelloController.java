package com.bootstrap.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A Spring {@link RestController} used to showcase the modeling of a REST controller for CRUD operations
 *
 * @author Odilio Noronha Filho
 */
@RestController
@RequestMapping(
        path = "/hello"
)
public class HelloController {


    /**
     * @return Hello World!
     */
    @GetMapping()
    public String get() {
        return "Hello World!";
    }

   
}
