package com.bootstrap.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootstrap.springboot.model.Product;
import com.bootstrap.springboot.model.dto.ProductDTO;
import com.bootstrap.springboot.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
    private ProductRepository productRepository;

    public void create(final Product productDTO) {
        productRepository.save(productDTO);
    }

    public Optional<Product> get(Long id) {
        final Optional<Product> product =
                productRepository.findById(id);

        return product;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public void update(final int id, final ProductDTO productDTO) {
       // productRepository.update(id, getDTOConverter().apply(productDTO));
    }

    public void delete(final int id) {
        //TODO
    }


    private Predicate<Product> filterItem() {
        return product -> !product.getName().isEmpty() || product.getId() < 50;
    }
}
