package com.bootstrap.springboot.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable {

    private int id;

    private String name;
    
    public Product() {
    }

    public Product(int id, String name) {
        this.id = id; this.name = name;
    }

}
