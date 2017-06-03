package com.king.action.product;

import com.king.dao.Dao;
import com.king.model.Product;
import com.king.other.Parser;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by king on 2017/5/23.
 */
public class DetailAction extends ActionSupport {
    private Product product=new Product();
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

    public String execute() throws Exception {
        product.setId(id);
        product= (Product) Parser.generatePOJO(product,Dao.executeSQL(Dao.S,product)).get(0);
        return SUCCESS;
    }
}
