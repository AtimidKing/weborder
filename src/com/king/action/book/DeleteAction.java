package com.king.action.book;

import com.king.dao.implement.BookDAOImplement;
import com.king.dao.interfaces.BookDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO=new BookDAOImplement();
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String execute() {
		try {
			bookDAO.deleteBook(id);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}

	}
}
