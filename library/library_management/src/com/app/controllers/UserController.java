package com.app.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.services.IUserService;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/library")
public class UserController 
{
	@Autowired
	private IUserService service;
	
	@PostConstruct
	public void init() 
	{
		System.out.println("in init " + service);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> addUserDetails(@RequestBody User u)
	{
		System.out.println("in add user dtls " + u);
		try {
			return new ResponseEntity<User>(service.AddUser(u), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
   @PostMapping("/login")
   public ResponseEntity<?> LoginUser(@RequestBody User u)
   {
	   System.out.println("in user dtls " + u.getEmail() +" "+u.getPassword());
		User u1 = service.loginUser(u.getEmail(),u.getPassword());
		if (u1 == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<User>(u1, HttpStatus.OK);
	}

  
	
}
