package com.devgm.gmdelivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devgm.gmdelivery.entities.Product;

public interface ProductRepository extends JpaRepository<Product,  Long>{
	
	public List<Product> findAllByOrderByNameAsc();
	
}
