package com.bootstrap.springboot.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootstrap.springboot.model.Product;
import com.bootstrap.springboot.model.dto.ProductDTO;
import com.bootstrap.springboot.service.ProductService;
import com.bootstrap.springboot.util.Converter;


/**
 * A Spring {@link RestController} used to modeling of a REST controller for Product CRUD operations
 *
 * @author Odilio Noronha Filho
 */
@RestController
@RequestMapping(
        path = "/product"
)
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
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody Product product) {
        productService.create(product);
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
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
    	Optional<Product> prod = productService.get(id);
    	
    	if (prod != null) {
    		// TODO Create a generic converter to HATEOAS
    		ProductDTO prodDTO = (ProductDTO) Converter.toModel(prod.get(), ProductDTO.class);
    		Link selfLink = linkTo(methodOn(CategoryController.class)
                    .getCategory(prod.get().getCategory().getId())).withSelfRel();
    		prodDTO.getCategoryDTO().add(selfLink);
    		prodDTO.add(linkTo(methodOn(ProductController.class).getProduct(id)).withSelfRel());
    		ResponseEntity.ok(prodDTO);
    	}
    		
    	
        return ResponseEntity.notFound().build();
    }

    /**
     * Reads all the existing {@link Product}s
     *
     * @return the serialized {@link ProductDTO}s
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
     
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable final int id, @RequestBody ProductDTO productDTO) {
        productService.update(id, productDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
*/
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
