package com.app.dao;

import com.app.pojos.Book;

public interface IBookDao 
{
  Book getBookById(int id);
  Book addNewBook(Book bk);
}
