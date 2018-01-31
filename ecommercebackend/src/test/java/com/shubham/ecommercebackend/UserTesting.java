package com.shubham.ecommercebackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.ecommercebackend.config.Config;
import com.shubham.ecommercebackend.dao.UserDao;
import com.shubham.ecommercebackend.dto.Address;
import com.shubham.ecommercebackend.dto.Cart;
import com.shubham.ecommercebackend.dto.User;


public class UserTesting {
	
	
	private static UserDao userDao;
	
	private static AnnotationConfigApplicationContext context;
	
	private User user;
	private Address address;
	private Cart cart;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext(Config.class);
		
		userDao =  (UserDao)context.getBean("userDao");
	}
	
/*	@Test
	public void userAdd()
	{
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("CUSTOMER");
		user.setEnabled(true);
		user.setPassword("12345");
		
	}
	
	@Test
	public void userAddress()
	{
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
	}
	
	@Test
	public void userCart()
	{
		cart = new Cart();
		
		// linked the address with the user
		address.setUser(user);
		
		// linked the cart with the user
		cart.setUser(user);
		// link the user with the cart
		user.setCart(cart);
	}*/
	
	/*@Test
	public void userAddAddresCart()
	{
		
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");
		
		// add the user
		assertEquals("Failed to add the user!", true, userDao.addUser(user));	
		
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		//link user with address
		address.setUserId(user.getId());
		// add the address
		assertEquals("Failed to add the billing address!", true, userDao.addAddress(address));
		
		if(user.getRole().equals("USER"))
		{
			cart = new Cart();
			cart.setUser(user);
			
			assertEquals("Failed to add the cart!", true, userDao.addCart(cart));

		}
								
		// add the shipping address
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setShipping(true);
		//link with user
		assertEquals("Failed to add the shipping address!", true, userDao.addAddress(address));
		
	}*/
	
	
	/*@Test
	public void userAddAddresCart()
	{
		
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");
		
		
		
		
		if(user.getRole().equals("USER"))
		{
			cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
			

		}
								
		// add the user
		assertEquals("Failed to add the user!", true, userDao.addUser(user));	
		
	}*/
	
	/*@Test
	public void userUpdateCart()
	{
		//fetch user row by its id
		user = userDao.getByEmail("hr@gmail.com");
		
		//get cart by id
		cart = user.getCart();
		cart.setGrandTotal(6542);
		cart.setCartLines(2);
		assertEquals("Failed to update the cart!", true, userDao.updateCart(cart));
	}
*/
	
	/*@Test
	public void testCaseAddUserAddressCartByMappingHibernate()
	{
		
		//add user
		user = new User() ;
		user.setFirstName("Shubha");
		user.setLastName("Roshan");
		user.setEmail("sh@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");
		// add the user
		assertEquals("Failed to add the user!", true, userDao.addUser(user));	
		
		//add billing address
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mathura");
		address.setState("UP");
		address.setCountry("India");
		address.setPostalCode("281001");
		address.setBilling(true);
		//attach user with address
		address.setUser(user);
		// add the address
		assertEquals("Failed to add the billing address!", true, userDao.addAddress(address));	
		
		//add shipping address
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krishna Nagar");
		address.setAddressLineTwo("Near Dampier");
		address.setCity("Mathura");
		address.setState("UP");
		address.setCountry("India");
		address.setPostalCode("281001");
		address.setShipping(true);
		//attach user with address
		address.setUser(user);
		// add the address
		assertEquals("Failed to add the shipping address!", true, userDao.addAddress(address));	
		
	}*/
	
	/*@Test
	public void addAnotherShippingAddressByUSer()
	{
		//get used by email
		user = userDao.getByEmail("sh@gmail.com");
		//add shipping address
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krishna Nagar");
		address.setAddressLineTwo("Near Dampier");
		address.setCity("Delhi");
		address.setState("Delhi");
		address.setCountry("India");
		address.setPostalCode("100001");
		address.setShipping(true);
		//attach user with address
		address.setUser(user);
		// add the address
		assertEquals("Failed to add the shipping address!", true, userDao.addAddress(address));	
	}*/
	
	@Test
	public void getShippingAddressByUser()
	{
		//get used by email
		user = userDao.getByEmail("sh@gmail.com");
		
		assertEquals("Failed to get the shipping address!", 2, userDao.getShippingAddresses(user).size());
		assertEquals("Failed to get the billing address!", "Mathura", userDao.getBillingAddress(user).getCity());
	}
}
