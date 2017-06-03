package com.king.dao.implement;

import com.king.dao.DAOSupport;
import com.king.dao.interfaces.UserDAO;
import com.king.model.User;
import com.king.validation.Encrypter;

public class UserDAOImplement extends DAOSupport implements UserDAO {

	@Override
	public boolean validateUser(User user) throws Exception {
		try {
			java.sql.ResultSet rSet=this.execSql("select password from user where username=?", user.getUsername());
			if (rSet.next()) {
				String password_MD5=Encrypter.md5Encypter(user.getPassword());
				if (password_MD5.equals(rSet.getString("password"))) {
					return true;
				}
			}
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
			throw new Exception("通信异常，登录失败");
		}
		finally {
			close();
		}
		return false;
	}

	@Override
	public void addUser(User user) throws Exception {
		try {
			String password_md5=Encrypter.md5Encypter(user.getPassword());
			this.execSql("insert into user values(?,?,?)", 
					user.getUsername(),password_md5,user.getEmail());
			
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
			throw new Exception("发生异常，注册失败。");
		}
	}

}
