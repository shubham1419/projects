package com.shubham.ecommercebackend;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.ecommercebackend.config.Config;
import com.shubham.ecommercebackend.dao.CategoryDao;
import com.shubham.ecommercebackend.dto.Category;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws SQLException
    {
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    	CategoryDao dao = context.getBean(CategoryDao.class);
       
        Category cat = new Category();
      
        cat.setName("lap");
        cat.setDescription("description");
        cat.setImage_url("lap_1.png");
        dao.add(cat);
       
        context.close();
    }
}