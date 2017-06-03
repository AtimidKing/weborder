package com.king.action.product;

import com.king.dao.Dao;
import com.king.model.Product;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by king on 2017/5/11.
 */
public class DeleteAction extends ActionSupport{
    private Product product;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String execute() {
        product=new Product();
        try {
            product.setId(id);
            Dao.executeSQL(Dao.D,product);

        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError(e.toString());
            return INPUT;
        }
        return SUCCESS;
    }

}
