package com.shubham.ecommercebackend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.ecommercebackend.config.Config;
import com.shubham.ecommercebackend.dao.ProductDao;
import com.shubham.ecommercebackend.dto.Product;


public class ProductTesting {
	
	
	private static ProductDao productDao;
	
	private static AnnotationConfigApplicationContext context;
	
	private Product product;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext(Config.class);
		
		productDao =  context.getBean(ProductDao.class);
	}
	
/*	
	@Test
	public void crudOprerationProducts()
	{
		add category
		product = new Product();
		product.setName("Oppo F5");
		product.setBrand("Oppo");
		product.setDescription("The selfie expert");
		product.setUnitPrice(25000);
		product.setQuantity(4);
		product.setActive(true);
		product.setSupplierId(3);
		product.setCategoryId(3);
		assertEquals("Something went wrong", true, productDao.add(product));
		
		get product by id
		product = productDao.get(3);
		assertEquals("Something went wrong", "Google Pixel", product.getName());
		
		update product
		product = productDao.get(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("Something went wrong", true, productDao.update(product));
	
		delete product
		assertEquals("Something went wrong", true, productDao.delete(product));
	
		list product
		assertEquals("Something went wrong",6, productDao.list().size());
	}*/
	
	
	@Test
	public void  allActiveProducts() 
	{
		assertEquals("Something went wrong",5, productDao.allActiveProducts().size());
	}

		
	@Test
	public void allActiveProductsByCategory()
	
	{
		assertEquals("Something went wrong",3, productDao.allActiveProductsByCategory(3).size());
		assertEquals("Something went wrong",2, productDao.allActiveProductsByCategory(1).size());

	}
	
	@Test
	public void getLatestActiveProducts()
	{
		assertEquals("Something went wrong",3, productDao.getLatestActiveProducts(3).size());

	}
}

