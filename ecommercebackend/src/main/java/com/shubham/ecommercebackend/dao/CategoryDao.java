package com.shubham.ecommercebackend.dao;

import java.util.List;

import com.shubham.ecommercebackend.dto.Category;


public interface CategoryDao {
	
	void data(Category category);
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
}
