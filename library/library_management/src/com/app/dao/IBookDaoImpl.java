package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Book;

@Repository
public class IBookDaoImpl implements IBookDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Book getBookById(int id) {
		return sf.getCurrentSession().get(Book.class, id);
		
	}

	@Override
	public Book addNewBook(Book bk) {
		sf.getCurrentSession().persist(bk);
		return bk;
	}
	

	
}