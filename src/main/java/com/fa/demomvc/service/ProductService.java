package com.fa.demomvc.service;

import java.util.List;

import com.fa.demomvc.entity.Product;

public interface ProductService {

	public List<Product> findAll();

	public void saveOrUpdate(Product product);

	public void delete(long id);

	public Product findById(long id);
}
