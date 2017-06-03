package com.king.action.shopbasket;

import com.king.dao.Dao;
import com.king.model.Product;
import com.king.other.Parser;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by king on 2017/5/17.
 */
public class PayAction extends ActionSupport {
    private String id;
    private String name;
    private String price;
    private String amount;
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String execute() {
        try {
            Product product = new Product();
            product.setId(id);
            product = (Product) Parser.generatePOJO(product, Dao.executeSQL(Dao.S, product)).get(0);
            name=product.getProductName();
            price=product.getProductPrice();
            Double tempTotal=Double.parseDouble(amount)*Double.parseDouble(price);
            total=tempTotal.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }
}
