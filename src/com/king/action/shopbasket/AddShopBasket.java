package com.king.action.shopbasket;

import com.king.model.ShopProduct;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by king on 2017/5/15.
 */
public class AddShopBasket extends ActionSupport implements ServletRequestAware {
    private ShopProduct shopProduct;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private javax.servlet.http.HttpServletRequest request;
    public String execute(){
        String basket="";
        ActionContext actionContext = ActionContext.getContext();
        java.util.Map<String, Object> sessionMap = actionContext.getSession();
        if (sessionMap.containsKey("shopBasket")) {
            basket=sessionMap.get("shopBasket").toString();
        }
        basket=basket+id+",1;";
        System.out.println(id);
        System.out.println(basket);
        javax.servlet.http.HttpSession session=request.getSession();
        session.setAttribute("shopBasket", basket);
        session.setMaxInactiveInterval(60*60*3);
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }


}
