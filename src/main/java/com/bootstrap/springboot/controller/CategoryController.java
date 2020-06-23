package com.bootstrap.springboot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootstrap.springboot.model.Category;
import com.bootstrap.springboot.model.dto.CategoryDTO;
import com.bootstrap.springboot.service.CategoryService;
import com.bootstrap.springboot.util.Converter;


/**
 * A Spring {@link RestController} used to showcase the modeling of a REST controller for CRUD operations
 *
 * @author Odilio Noronha Filho
 */
@RestController
@RequestMapping(
        path = "/category"
)

public class CategoryController {

	@Autowired
    private CategoryService productService;
    
    
    /**
     * Creates a {@link Category} from the referenced {@link CategoryDTO}
     *
     * @param productDTO the {@link Category} to be created
     *
     * @return a {@link ResponseEntity} with the appropriate {@link HttpStatus}
     */
    @PostMapping
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody Category product) {
        productService.create(product);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Reads the {@link Category} with the specified id
     *
     * @param id the id of the requested {@link Category}
     *
     * @return the serialized {@link Category}
     */
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}"
    )
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Long id) {
    	Optional<Category> prod = productService.get(id);
    	
    	if (prod != null) {
    		CategoryDTO prodDTO = (CategoryDTO) Converter.toModel(prod.get(), CategoryDTO.class);
    		 ResponseEntity.ok(prodDTO);
    	}
    		
    	
        return ResponseEntity.notFound().build();
    }

    /**
     * Reads all the existing {@link Category}s
     *
     * @return the serialized {@link Category}s
     */
    @RequestMapping(
            method = RequestMethod.GET,
            path = ""
    )
    public List<CategoryDTO> getAll() {
        return (List<CategoryDTO>)Converter.toCollection(productService.getAll(), CategoryDTO.class);
    }

    /**
     * Updates the {@link Category} with the specified ID with the details from the referenced {@link Category}
     *
     * @return a {@link ResponseEntity} with the appropriate {@link HttpStatus}
     */
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable final int id, @RequestBody CategoryDTO productDTO) {
        //productService.update(id, productDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Deletes the {@link Category} with the specified ID
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
