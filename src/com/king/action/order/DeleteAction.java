package com.king.action.order;

import com.king.dao.Dao;
import com.king.model.Order;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by king on 2017/5/11.
 */
public class DeleteAction extends ActionSupport{
    private Order order;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String execute() {
        try {
            order=new Order();
            order.setId(id);
            Dao.executeSQL(Dao.D, order);
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError(e.toString());
            return ERROR;
        }
        return SUCCESS;
    }
}
