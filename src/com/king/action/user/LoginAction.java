package com.king.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.king.dao.implement.UserDAOImplement;
import com.king.dao.interfaces.UserDAO;
import com.king.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public String execute() {
		
		UserDAO userDAO= new UserDAOImplement();
		Object object=ActionContext.getContext().
				getSession().get("validation_code");
		String validationCode=(object!=null)?object.toString():"";
		if (!validationCode.equalsIgnoreCase(user.getValidationCode())) {
			if (user.getValidationCode()!=null) {
				this.addActionError("");
			}
			return INPUT;
		}
		try {
			if (!userDAO.validateUser(user)) {
				this.addActionError("用户名或密码不正确");
				return INPUT;
			}
		} catch (Exception e) {
			this.addActionError(e.toString());
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		session.setAttribute("username", user.getUsername());
		session.setMaxInactiveInterval(60*60*3);
		return SUCCESS;
	}
}
