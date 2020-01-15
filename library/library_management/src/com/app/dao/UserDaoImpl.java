package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository
public class UserDaoImpl implements IUserDao
{
	@Autowired
	private SessionFactory sf;

	@Override
	public User LoginUser(String email, String password) {
		
		
			String jpql = "select u from User u where u.email=:em and u.password=:pass";
			return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email)
					.setParameter("pass", password).getSingleResult();
		
		
	}

	@Override
	public User registerNewUser(User v) {
		sf.getCurrentSession().persist(v);
		return v;
	}

}
