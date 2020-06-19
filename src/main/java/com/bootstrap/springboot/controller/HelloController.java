package com.bootstrap.springboot.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * A Spring {@link RestController} used to showcase the modeling of a REST controller for CRUD operations
 *
 * @author Odilio Noronha Filho
 */
@RestController
@RequestMapping(
        path = "/hello"
)
@Api(value = "Hello")
public class HelloController {

	@Autowired
    MessageSource messageSource;

    /**
     * @return Hello World!
     */
    @GetMapping()
    public String get() {
        return "Hello World!";
    }

    @GetMapping("/")
    public String index(Locale locale) {
        return messageSource.getMessage("ola", null, locale);
    }
   
}
