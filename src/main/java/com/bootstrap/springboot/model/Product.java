package com.bootstrap.springboot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Product implements Serializable {

    private int id;

    private String name;
    
    public Product() {
    }

    public Product(int id, String name) {
        this.id = id; this.name = name;
    }

}
