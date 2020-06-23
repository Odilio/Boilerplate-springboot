package com.bootstrap.springboot.model.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.bootstrap.springboot.model.Category;

import lombok.Data;

/**
 * A DTO (Data Transfer Object) used to serialize / deserialize {@link Category} objects
 *
 * @author Odilio Noronha Filho
 */
@Data
public class CategoryDTO extends RepresentationModel <CategoryDTO> implements Serializable {

    private int id;

    private String productName;

    public CategoryDTO(final int id, final String productName) {
        this.id = id; this.productName = productName;
    }

}
