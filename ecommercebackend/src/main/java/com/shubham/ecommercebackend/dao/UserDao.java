package com.shubham.ecommercebackend.dao;

import java.util.List;

import com.shubham.ecommercebackend.dto.Address;
import com.shubham.ecommercebackend.dto.Cart;
import com.shubham.ecommercebackend.dto.User;

public interface UserDao {
	
	/*add user*/
	boolean addUser(User user);
	User getByEmail(String email);
	/*add address*/
	boolean addAddress(Address address);
	
	Address getBillingAddress(User user);
	List<Address> getShippingAddresses(User user);
	/*above alternative to shorten the query but not used*/
	//Address getBillingAddress(int userId);
	//List<Address> getShippingAddresses(int userId);
	/*alternative end*/
	/*add cart*/
	boolean updateCart(Cart cart);

}
