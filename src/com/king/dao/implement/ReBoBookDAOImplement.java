package com.king.dao.implement;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.king.dao.DAOSupport;
import com.king.dao.interfaces.ReBoBookDAO;
import com.king.model.Book;
public class ReBoBookDAOImplement extends DAOSupport implements ReBoBookDAO {


	@Override
	public void returnBook(int booid) throws Exception {
		java.util.Date date=new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.execSql("UPDATE borrowrecord SET redate = ? WHERE bookid = ? and redate is null",sdf.format(date),booid);
		
	}

	@Override
	public void borrowBook(int bookId, String userId) throws Exception {
		java.util.Date date=new java.util.Date();
		SimpleDateFormat sdfDate=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		java.sql.ResultSet resultSet=this.execSql("SELECT count(*) FROM lms.borrowrecord where borrowrecord.bookid=? and redate is null",bookId);
		int count=0;
		while (resultSet.next()) {
			count=resultSet.getInt("count(*)");
		}
		if (count>0) {
			throw new Exception("该书也被借走！");
		}
		this.execSql("INSERT INTO borrowrecord (`id`,`username`,`bookid`,`date`)VALUES(?,?,?,?)", 
				sdf.format(date),userId,bookId,sdfDate.format(date));	
	}

	@Override
	public List<Book> searchRecord(String username) throws Exception {
		java.sql.ResultSet resultSet =this.execSql("SELECT book.id ,name, author, sort,publishunit,publishdate,address  FROM lms.book,lms.borrowrecord where lms.book.id=lms.borrowrecord.bookid and borrowrecord.username=?", username);
		List<Book> list=new ArrayList<Book>();
		bookORM(list, resultSet);
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
}
