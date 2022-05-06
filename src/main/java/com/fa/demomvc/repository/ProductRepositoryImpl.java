package com.fa.demomvc.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fa.demomvc.entity.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class).getResultList();
		return products;
	}

	@Override
	public void saveOrUpdate(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}

	@Override
	public void delete(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
	}

	@Override
	public Product findById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Product.class, id);
	}
}
