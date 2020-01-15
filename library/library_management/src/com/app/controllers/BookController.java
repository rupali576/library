package com.app.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.Book;

import com.app.services.IBookServices;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/books")
public class BookController 
{
	@Autowired
	private IBookServices service;
	
	@PostConstruct
	public void init() 
	{
		System.out.println("in init " + service);
	}
	@GetMapping("/{bookId}")
	public ResponseEntity<?> getBookDetails(@PathVariable int bookId) {
		System.out.println("in emp dtls " + bookId);
		Book b = service.getBookById(bookId);
		if (b == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Book>(b, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addUserDetails(@RequestBody Book bk)
	{
		System.out.println("in add book dtls " + bk);
		try {
			return new ResponseEntity<Book>(service.addNewBook(bk), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
