package com.king.action.book;

import com.king.dao.implement.BookDAOImplement;
import com.king.dao.interfaces.BookDAO;
import com.king.model.Book;
import com.opensymphony.xwork2.ActionSupport;

public class AddAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Book book;
	private BookDAO bookDAO=new BookDAOImplement();
	public String execute() {
		System.out.println(book.getName());
		try {
			bookDAO.addBook(book);
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
