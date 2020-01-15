package com.app.services;

import com.app.pojos.User;


public interface IUserService 
{
	User AddUser(User u);
	User loginUser(String email,String password);
}
