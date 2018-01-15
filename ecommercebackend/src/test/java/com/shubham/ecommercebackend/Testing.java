package com.shubham.ecommercebackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.ecommercebackend.config.Config;
import com.shubham.ecommercebackend.dao.CategoryDao;
import com.shubham.ecommercebackend.dto.Category;

public class Testing {
	
	
	private static CategoryDao categoryDao;
	
	private static AnnotationConfigApplicationContext context;
	
	private Category category;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext(Config.class);
		
		categoryDao =  context.getBean(CategoryDao.class);
	}
	
	/*@Test
	public void testAddCategory()	{
		category = new Category();
		category.setName("Mobile");
		category.setDescription("This is descrition for mobile");
		category.setImage_url("mobile_1.png");
		//categoryDao.data(category);
		
	assertEquals("Successfully inserted the category", true, categoryDao.add(category));
	}*/
	
	/*@Test
	public void testGetCategory()	{
		category = categoryDao.get(3);
		
	assertEquals("Successfully fetched single category", "Mobile", category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory()	{
		category = categoryDao.get(2);
		category.setName("AC");
	assertEquals("Successfully updated single category", true, categoryDao.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory()	{
		category = categoryDao.get(2);
	assertEquals("Successfully deleted single category", true, categoryDao.delete(category));
	}*/
	
	/*@Test
	public void testListCategory()	{
	assertEquals("Successfully fetched acive categories",2, categoryDao.list().size());
	}*/
	
	@Test
	public void crudOprerationCategories()
	{
		/*add category*/
		category = new Category();
		category.setName("Desktop");
		category.setDescription("This is descrition for desktop");
		category.setImage_url("desktop_1.png");
		assertEquals("Successfully inserted the category", true, categoryDao.add(category));
		
		/*get category by id*/
		category = categoryDao.get(3);
		assertEquals("Successfully fetched single category", "Mobile", category.getName());
		
		/*update category*/
		category = categoryDao.get(2);
		category.setName("AC");
		assertEquals("Successfully updated single category", true, categoryDao.update(category));
	
		/*delete category*/
		assertEquals("Successfully deleted single category", true, categoryDao.delete(category));
	
		/*delete category*/
		assertEquals("Successfully fetched acive categories",3, categoryDao.list().size());
	}
	
		 
}

