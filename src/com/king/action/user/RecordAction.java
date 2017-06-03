package com.king.action.user;

import java.util.List;

import com.king.dao.implement.ReBoBookDAOImplement;
import com.king.dao.interfaces.ReBoBookDAO;
import com.king.model.Book;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RecordAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Book book;
	private List<Book> listBook;
	
	public List<Book> getListBook() {
		return listBook;
	}
	public void setListBook(List<Book> listBook) {
		this.listBook = listBook;
	}
	private ReBoBookDAO	 boBookDAO =new ReBoBookDAOImplement();
		
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String execute() {
		ActionContext actionContext=ActionContext.getContext();
		java.util.Map<String, Object> session = actionContext.getSession();
		try {
			String username =(String) session.get("username");
			listBook=boBookDAO.searchRecord(username);
			return SUCCESS;
		} catch (NullPointerException e) {
			return LOGIN;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	

}
