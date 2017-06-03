package com.king.dao.interfaces;

import java.util.List;

import com.king.model.Book;

public interface BookDAO {

	public List<Book> searchBook() throws Exception;

	public void modifyBook(Book book)throws Exception;

	public void deleteBook(int id)throws Exception;

	public void addBook(Book book)throws Exception;

	public Book searchBook(int id)throws Exception;

	public List<Book> searchBook(String keyword)throws Exception;

}
