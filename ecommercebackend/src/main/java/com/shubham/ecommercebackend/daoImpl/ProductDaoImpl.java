package com.shubham.ecommercebackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.ecommercebackend.dao.ProductDao;
import com.shubham.ecommercebackend.dto.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	/* Single product */
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/* List of products */
	@Override
	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("FROM Product where categoryId != 0", Product.class).getResultList();
	}

	/* add product */

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/* update product */
	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try {
			sessionFactory.getCurrentSession().delete(product);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> allActiveProducts() {
		int categoryId = 0;
		String allActiveProductsByCategory = "from Product where active = :active and categoryId != :categoryId";
		return sessionFactory.getCurrentSession().createQuery(allActiveProductsByCategory, Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Product> allActiveProductsByCategory(int categoryId) {
		String allActiveProductsByCategory = "from Product where active = :active and categoryId = :categoryId";
		return sessionFactory.getCurrentSession().createQuery(allActiveProductsByCategory, Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Product where active = :active order by id ", Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

}
