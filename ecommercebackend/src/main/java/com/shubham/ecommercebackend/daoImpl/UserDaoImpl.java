package com.shubham.ecommercebackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.ecommercebackend.dao.UserDao;
import com.shubham.ecommercebackend.dto.Address;
import com.shubham.ecommercebackend.dto.Cart;
import com.shubham.ecommercebackend.dto.User;


@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		
		try 
		{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;	
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try 
		{
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;	
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try 
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;	
		}
	}

	@Override
	public User getByEmail(String email) {
		try 
		{
			String query = "From User where email=:email";
			return sessionFactory.getCurrentSession().createQuery(query,User.class).setParameter("email",email).getSingleResult();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;	
		}
	}

	@Override
	public Address getBillingAddress(User user) {
		String query="from Address where user=:user and billing=:billing";
		try {
			
			return sessionFactory.getCurrentSession().createQuery(query,Address.class).setParameter("user", user).setParameter("billing",true).getSingleResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Address> getShippingAddresses(User user) {
		String query="from Address where user=:user and shipping=:shipping";
		try {
			
			return sessionFactory.getCurrentSession().createQuery(query,Address.class).setParameter("user", user).setParameter("shipping",true).getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

}
