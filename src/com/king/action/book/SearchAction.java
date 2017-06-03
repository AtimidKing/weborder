package com.king.action.book;

import java.util.List;

import com.king.dao.implement.BookDAOImplement;
import com.king.dao.interfaces.BookDAO;
import com.king.model.Book;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Book> listBook;
	private String keyword;
	private BookDAO bookDAO=new BookDAOImplement();
	
	
	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<Book> getListBook() {
		return listBook;
	}


	public void setListBook(List<Book> listBook) {
		this.listBook = listBook;
	}


	public String execute() {
		try {
			listBook=bookDAO.searchBook(keyword);
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			return ERROR;
		}

	}
}
