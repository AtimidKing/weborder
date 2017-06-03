package com.king.action.order;

import com.king.dao.Dao;
import com.king.model.Order;
import com.king.model.Product;
import com.king.model.ShopProduct;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

/**
 * Created by king on 2017/5/11.
 */
public class CreateAction extends ActionSupport implements ServletRequestAware {
    private Order order;
    private Product product;
    private ShopProduct shopProduct;
    private String id;
    private int amount;
    private javax.servlet.http.HttpServletRequest request;

    public ShopProduct getShopProduct() {
        return shopProduct;
    }

    public void setShopProduct(ShopProduct shopProduct) {
        this.shopProduct = shopProduct;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String execute() {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        order=new Order();
        order.setId(sdf.format(date));
        order.setOrderDate(sdfDate.format(date));
        order.setProductAmount("" + amount);
        try {
            ActionContext actionContext = ActionContext.getContext();
            java.util.Map<String, Object> session = actionContext.getSession();
            String cId = (String) session.get("id");
            order.setCsrID(cId);
            order.setProductID(id);
            Dao.executeSQL(Dao.I, order);
            String basket= (String) session.get("shopBasket");
            basket=basket.replace(id+","+amount+";","");
            javax.servlet.http.HttpSession session1=request.getSession();
            session1.setAttribute("shopBasket", basket);
            session1.setMaxInactiveInterval(60*60*3);
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError(e.toString());
            return INPUT;
        }
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }
}
