package com.king.action.user;

import com.king.dao.implement.UserDAOImplement;
import com.king.dao.interfaces.UserDAO;
import com.king.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private String result;	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String execute() {
		UserDAO userDAO=new UserDAOImplement();
		Object object=ActionContext.
				getContext().getSession().get("validation_code");
		String validationCode=(object!=null)?object.toString():"";
		if (!validationCode.equalsIgnoreCase(user.getValidationCode())) {
			if (user.getValidationCode()!=null) {
				this.addActionError("验证码输入错误。");
			}
			return INPUT;
		}
		try {
			userDAO.addUser(user);  
		} catch (java.sql.SQLException e) {
			this.addActionError(e.getMessage());
			return INPUT;
		} catch (Exception e) {
			this.addActionError("发生了未知的错误！");
			e.printStackTrace();
			return INPUT;
		}
		result="用户"+user.getUsername()+">注册成功";
		return SUCCESS;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}
}
