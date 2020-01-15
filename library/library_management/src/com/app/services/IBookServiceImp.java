package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.dao.IBookDao;
import com.app.pojos.Book;

@Service // B.L methods
@Transactional
public class IBookServiceImp implements IBookServices
{
	@Autowired
	private IBookDao dao;
	
	
	@Override
	public Book getBookById(int id) 
	{
		return dao.getBookById(id);
	}


	@Override
	public Book addNewBook(Book bk) {
		
		return dao.addNewBook(bk);
	}

}
