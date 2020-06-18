package com.bootstrap.springboot.dto;

import java.io.Serializable;

import com.bootstrap.springboot.model.Product;

import lombok.Data;

/**
 * A DTO (Data Transfer Object) used to serialize / deserialize {@link Product} objects
 *
 * @author Odilio Noronha Filho
 */
@Data
public class ProductDTO implements Serializable {

    private int id;

    private String productName;

    public ProductDTO() {
    }

    public ProductDTO(final int id, final String productName) {
        this.id = id; this.productName = productName;
    }

}
