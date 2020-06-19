package com.bootstrap.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Product implements Serializable {

	private static final long serialVersionUID = -5752805178427746354L;

	@Id
	@Column
	@NotNull
    private int id;

	@Column
    private String name;
    
    public Product() {
    }

    public Product(int id, String name) {
        this.id = id; this.name = name;
    }

}
