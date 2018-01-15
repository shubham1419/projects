package com.shubham.ecommercebackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.ecommercebackend.dao.CategoryDao;
import com.shubham.ecommercebackend.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void data(Category category) {
		
			sessionFactory.getCurrentSession().save(category);			
		
	}

	@Override
	public List<Category> list() {
		String allActiveCategories = "from Category where active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(allActiveCategories);
		query.setParameter("active", true);
		return query.getResultList();
	}
	
	/*for getting single category by id*/
	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
