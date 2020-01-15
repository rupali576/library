package com.app.dao;

import com.app.pojos.User;

public interface IUserDao 
{
   User LoginUser(String email,String password);
   User registerNewUser(User v);
}
