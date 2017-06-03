package com.king.dao.interfaces;

import java.util.List;

import com.king.model.Book;

public interface ReBoBookDAO {
	public void returnBook(int booid)throws Exception;
	public void borrowBook(int bookId, String userId)throws Exception;
	public List<Book> searchRecord(String username)throws Exception;

}
