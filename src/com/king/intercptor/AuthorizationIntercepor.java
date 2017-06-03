package com.king.intercptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorizationIntercepor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ignoreAction;
	public String getIgnoreAction() {
		return ignoreAction;
	}
	public void setIgnoreAction(String ignoreAction) {
		this.ignoreAction = ignoreAction;
	}
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		//获取上下文对象
		ActionContext actionContext= arg0.getInvocationContext();
		java.util.Map<String, Object> session=actionContext.getSession();
		String id=(String) session.get("id");
		boolean ignore= false;
		String currentAction=arg0.getProxy().getActionName();
		String[] actions=ignoreAction.split(",");
		for (String action : actions) {
			if (action.trim().equals(currentAction)) {
				ignore=true;
				break;
			}
		}
		if (id!=null|| ignore==true) {
			return arg0.invoke();
		}else {
			return Action.LOGIN;
		}
	}
}
