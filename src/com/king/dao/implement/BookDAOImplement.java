package com.king.dao.implement;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.king.dao.DAOSupport;
import com.king.dao.interfaces.BookDAO;
import com.king.model.Book;

public class BookDAOImplement extends DAOSupport implements BookDAO {

	@Override
	public List<Book> searchBook() throws Exception {
		List<Book> list = new ArrayList<Book>();
		try {
			java.sql.ResultSet resultSet = this.execSql("SELECT * FROM book");
			bookORM(list, resultSet);
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	private void bookORM(List<Book> list, java.sql.ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			com.king.model.Book book = new com.king.model.Book();
			book.setId(Integer.parseInt(resultSet.getString("id")));
			book.setName(resultSet.getString("name"));
			book.setAuthor(resultSet.getString("author"));
			book.setSort(resultSet.getString("sort"));
			book.setPublishunit(resultSet.getString("publishunit"));
			book.setPublishdate(resultSet.getString("publishdate"));
			book.setAddress(resultSet.getString("address"));
			list.add(book);
		}
	}

	@Override
	public void modifyBook(Book book) throws Exception {
		try {
			this.execSql("UPDATE `lms`.`book`SET`id` = ?,"
					+ "`name` = ?,`author` = ?,`sort` = ?,"
					+ "`publishunit` = ?,`publishdate` = ?,"
					+ "`address` = ?WHERE `id` = ?", book.getId(),
					book.getName(),book.getAuthor(),book.getSort(),
					book.getPublishunit(),book.getPublishdate(),
					book.getAddress(),book.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteBook(int id) throws Exception {
		this.execSql("DELETE FROM book WHERE id=?;", id);
	}

	@Override
	public void addBook(Book book) throws Exception {
		Random random=new Random();
		java.util.Date date=new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddHHmm");
		String iString=sdf.format(date)+(random.nextInt(100));
		int id=Integer.parseInt(iString);
		book.setId(id);
		this.execSql("INSERT INTO book (`id`,`name`,`author`,`sort`,`publishunit`,`publishdate`,`address`)VALUES(?,?,?,?,?,?,?)", 
				book.getId(),book.getName(),book.getAuthor(),
				book.getSort(),book.getPublishunit(),book.getPublishdate(),
				book.getAddress());
	}

	@Override
	public Book searchBook(int id) throws Exception {
		java.sql.ResultSet resultSet = this.execSql("SELECT * FROM book where id=?",id);
		List<Book> list=new ArrayList<Book>();
		bookORM(list, resultSet);
		return list.get(0);
	}

	@Override
	public List<Book> searchBook(String keyword) throws Exception {
		java.sql.ResultSet resultSet = this.execSql("select * from book where name=? or author=? or sort=? or publishunit=?",keyword,keyword,keyword,keyword);
		List<Book> list=new ArrayList<Book>();
		bookORM(list, resultSet);
		return list;
	}

}
