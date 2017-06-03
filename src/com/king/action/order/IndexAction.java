package com.king.action.order;

import com.king.dao.Dao;
import com.king.model.Order;
import com.king.model.OrderDetail;
import com.king.model.Product;
import com.king.other.Parser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by king on 2017/5/11.
 */
public class IndexAction extends ActionSupport {
    private Order order;
    private OrderDetail orderDetail;

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    private java.util.List list;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String execute() {
        ActionContext actionContext=ActionContext.getContext();
        java.util.Map<String, Object> session = actionContext.getSession();
        list=new ArrayList();
        order=new Order();
        orderDetail=new OrderDetail();
        try {
            String customer =(String) session.get("id");
            order.setCsrID(customer);
            java.util.List orders=Parser.generatePOJO(order,Dao.executeSQL(Dao.S,order));
            for (int i = 0; i < orders.size(); i++) {
                Order o= (Order) orders.get(i);
                OrderDetail oDetail=new OrderDetail();
                oDetail.setId(o.getId());
                Product product=new Product();
                product.setId(o.getProductID());
                product= (Product) Parser.generatePOJO(product, Dao.executeSQL(Dao.S, product)).get(0);
                oDetail.setName(product.getProductName());
                oDetail.setNumber(o.getProductAmount());
                oDetail.setDate(o.getOrderDate());
                oDetail.setImage(product.getProductPicture());
                Double t=Double.parseDouble(product.getProductPrice())*Integer.parseInt(o.getProductAmount());
                oDetail.setTotal(t.toString());
                list.add(oDetail);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return INPUT;
        }
        return SUCCESS;
    }
}
