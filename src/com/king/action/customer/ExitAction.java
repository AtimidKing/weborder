package com.king.action.customer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by king on 2017/5/23.
 */
public class ExitAction extends ActionSupport {

    public String execute(){
        ActionContext actionContext = ActionContext.getContext();
        java.util.Map<String, Object> session = actionContext.getSession();
        session.remove("id");
        return SUCCESS;
    }

}
