package com.bootstrap.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootstrap.springboot.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	@Query("select c from Category c  where c.id = :id")
	Optional<Category> findById(@Param("id") Long id);
		
	@Query("select c from Category c")
	List<Category> findAll();
	
	
	@Query("select c from Category c")
	Page<Category> findAllPage(Pageable pageable);
}
