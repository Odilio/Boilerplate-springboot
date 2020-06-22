package com.bootstrap.springboot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootstrap.springboot.dto.ProductDTO;
import com.bootstrap.springboot.dto.UserDTO;
import com.bootstrap.springboot.model.Product;
import com.bootstrap.springboot.service.ProductService;
import com.bootstrap.springboot.util.Converter;

import io.swagger.annotations.Api;

/**
 * A Spring {@link RestController} used to showcase the modeling of a REST controller for CRUD operations
 *
 * @author Odilio Noronha Filho
 */
@RestController
@RequestMapping(
        path = "/product"
)
@Api(value = "Product")
public class ProductController {

	@Autowired
    private ProductService productService;
    
    
    /**
     * Creates a {@link Product} from the referenced {@link ProductDTO}
     *
     * @param productDTO the {@link Product} to be created
     *
     * @return a {@link ResponseEntity} with the appropriate {@link HttpStatus}
     */
    @PostMapping
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody ProductDTO productDTO) {
        productService.create(productDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Reads the {@link Product} with the specified id
     *
     * @param id the id of the requested {@link Product}
     *
     * @return the serialized {@link Product}
     */
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}"
    )
    public ResponseEntity<ProductDTO> getProduct(@PathVariable final int id) {
    	ProductDTO prod = productService.get(id);
    	
    	if (prod != null)
    		 ResponseEntity.ok(prod);
    	
        return ResponseEntity.notFound().build();
    }

    /**
     * Reads all the existing {@link Product}s
     *
     * @return the serialized {@link Product}s
     */
    @RequestMapping(
            method = RequestMethod.GET,
            path = ""
    )
    public List<ProductDTO> getAll() {
        return (List<ProductDTO>)Converter.toCollection(productService.getAll(), ProductDTO.class);
    }

    /**
     * Updates the {@link Product} with the specified ID with the details from the referenced {@link Product}
     *
     * @return a {@link ResponseEntity} with the appropriate {@link HttpStatus}
     */
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable final int id, @RequestBody ProductDTO productDTO) {
        productService.update(id, productDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Deletes the {@link Product} with the specified ID
     *
     * @return a {@link ResponseEntity} with the appropriate {@link HttpStatus}
     */
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/{id}"
    )
    public ResponseEntity<HttpStatus> delete(@PathVariable final int id) {
        productService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
