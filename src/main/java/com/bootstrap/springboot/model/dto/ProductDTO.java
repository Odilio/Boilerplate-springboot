package com.bootstrap.springboot.model.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.bootstrap.springboot.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO (Data Transfer Object) used to serialize / deserialize {@link Product} objects
 *
 * @author Odilio Noronha Filho
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends RepresentationModel <ProductDTO> implements Serializable {

    private int id;

    private String productName;

    private CategoryDTO categoryDTO;
    

}
