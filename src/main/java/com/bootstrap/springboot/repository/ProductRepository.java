package com.bootstrap.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootstrap.springboot.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("select c from Product c  where c.id = :id")
	Optional<Product> findById(@Param("id") Long id);
		
	@Query("select c from Product c")
	List<Product> findAll();
	
	
	@Query("select c from Product c")
	Page<Product> findAllPage(Pageable pageable);
}
