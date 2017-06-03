package com.king.action.shopbasket;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by king on 2017/5/17.
 */
public class DeleteAction extends ActionSupport implements ServletRequestAware {
    private String id;
    private String amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    private javax.servlet.http.HttpServletRequest request;
    public String execute(){
        ActionContext actionContext = ActionContext.getContext();
        java.util.Map<String, Object> session = actionContext.getSession();
        String cId = (String) session.get("id");
        String basket= (String) session.get("shopBasket");
        basket=basket.replace(id+","+amount+";","");
        javax.servlet.http.HttpSession session1=request.getSession();
        session1.setAttribute("shopBasket", basket);
        session1.setMaxInactiveInterval(60*60*3);
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }
}
