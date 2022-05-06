package com.fa.demomvc.repository;

import java.util.List;

import com.fa.demomvc.entity.Product;

public interface ProductRepository {

	public List<Product> findAll();

	public void saveOrUpdate(Product product);
	
	public void delete(Product product);
	
	public Product findById(long id);
	
}
