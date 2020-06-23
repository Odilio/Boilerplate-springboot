package com.bootstrap.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootstrap.springboot.model.Category;
import com.bootstrap.springboot.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
    private CategoryRepository categoryRepository;

    public void create(final Category category) {
    	categoryRepository.save(category);
    }

    public Optional<Category> get(Long id) {
        final Optional<Category> product =
        		categoryRepository.findById(id);

        return product;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public void update(final int id, final Category productDTO) {
       // productRepository.update(id, getDTOConverter().apply(productDTO));
    }

    public void delete(final int id) {
        //TODO
    }


    private Predicate<Category> filterItem() {
        return product -> !product.getName().isEmpty() || product.getId() < 50;
    }
}
