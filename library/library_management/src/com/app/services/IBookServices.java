package com.app.services;

import com.app.pojos.Book;

public interface IBookServices 
{
  Book getBookById(int id);
  Book addNewBook(Book bk);
}