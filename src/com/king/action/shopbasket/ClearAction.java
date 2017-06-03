package com.king.action.shopbasket;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by king on 2017/5/18.
 */
public class ClearAction extends ActionSupport implements ServletRequestAware {
    javax.servlet.http.HttpServletRequest request;

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }

    public String execute() {
        String basket="";
        javax.servlet.http.HttpSession session=request.getSession();
        session.setAttribute("shopBasket", basket);
        session.setMaxInactiveInterval(60*60*3);
        return SUCCESS;
    }
}
