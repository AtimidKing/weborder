package com.king.action.book;

import com.king.dao.implement.BookDAOImplement;
import com.king.dao.interfaces.BookDAO;
import com.king.model.Book;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO = new BookDAOImplement();
	private Book book;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String execute() {
		try {
			if (book == null) {
				book = bookDAO.searchBook(id);
				return "modify";
			} else {
				bookDAO.modifyBook(book);
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
}
