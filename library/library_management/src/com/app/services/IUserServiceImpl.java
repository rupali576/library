package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service // B.L methods
@Transactional
public class IUserServiceImpl implements IUserService 
{
	@Autowired
	private IUserDao dao;
	
	
	@Override
	public User AddUser(User u) 
	{
		return dao.registerNewUser(u);
	}


	@Override
	public User loginUser(String email, String password) {
		
		return dao.LoginUser(email, password);
	}

}
