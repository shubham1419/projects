package com.shubham.ecommercebackend.dao;

import java.util.List;

import com.shubham.ecommercebackend.dto.Product;

public interface ProductDao {
	
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//Business Methods
	List<Product> allActiveProducts();
	List<Product> allActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	

}
