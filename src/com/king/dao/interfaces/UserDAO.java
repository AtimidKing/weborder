package com.king.dao.interfaces;

import com.king.model.User;

public interface UserDAO {

	public boolean validateUser(User user)throws Exception;

	public void addUser(User user)throws Exception;

}
