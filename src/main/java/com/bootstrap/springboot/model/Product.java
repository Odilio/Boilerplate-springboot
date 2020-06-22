package com.bootstrap.springboot.model;

import java.io.Serializable;
import java.sql.Timestamp;

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
    private Long id;

	@Column
    private String name;
    
	@Column(name="created_at")
	private Timestamp createdAt;
	
    public Product() {
    }

    public Product(Long id, String name) {
        this.id = id; this.name = name;
    }

}
