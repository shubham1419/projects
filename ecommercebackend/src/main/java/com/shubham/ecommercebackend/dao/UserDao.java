package com.shubham.ecommercebackend.dao;

import com.shubham.ecommercebackend.dto.Address;
import com.shubham.ecommercebackend.dto.Cart;
import com.shubham.ecommercebackend.dto.User;

public interface UserDao {
	
	/*add user*/
	boolean addUser(User user);
	User getByEmail(String email);
	/*add address*/
	boolean addAddress(Address address);
	/*add cart*/
	boolean updateCart(Cart cart);

}
