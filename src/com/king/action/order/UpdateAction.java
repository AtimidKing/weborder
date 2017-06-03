package com.king.action.order;

import com.king.dao.Dao;
import com.king.model.Order;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by king on 2017/5/11.
 */
public class UpdateAction extends ActionSupport{
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String execute() {
        try {
            Dao.executeSQL(Dao.U,order);
        } catch (Exception e) {
            e.printStackTrace();
            return INPUT;
        }
        return SUCCESS;
    }
}
