package com.king.action.borrowreturn;

import com.king.dao.implement.ReBoBookDAOImplement;
import com.king.dao.interfaces.ReBoBookDAO;
import com.king.model.Book;
import com.king.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BorrowAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user=new User();
	private String temp;
	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	private ReBoBookDAO reBoBookDAO = new ReBoBookDAOImplement();
	public String execute() {
		System.out.println(book.getId());
		ActionContext actionContext=ActionContext.getContext();
		java.util.Map<String, Object> session = actionContext.getSession();
		try {
			String username =(String) session.get("username");
			System.out.println(username);
			user.setUsername(username);
			reBoBookDAO.borrowBook(book.getId(), user.getUsername());
			return SUCCESS;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return LOGIN;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}


}
