package com.king.action.borrowreturn;

import com.king.dao.implement.ReBoBookDAOImplement;
import com.king.dao.interfaces.ReBoBookDAO;
import com.king.model.Book;
import com.opensymphony.xwork2.ActionSupport;

public class ReturnAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Book book=new Book();
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	private ReBoBookDAO reBoBookDAO = new ReBoBookDAOImplement();

	public String execute() {
		
		try {
			reBoBookDAO.returnBook(book.getId());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
}
