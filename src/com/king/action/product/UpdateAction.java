package com.king.action.product;

import com.king.dao.Dao;
import com.king.model.Product;
import com.king.other.Parser;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by king on 2017/5/11.
 */
public class UpdateAction extends ActionSupport {
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
        try {
            if (product == null) {
                product=new Product();
                product.setId(id);
                java.util.List list = Parser.generatePOJO(product, Dao.executeSQL(Dao.S, product));
                product = (Product) list.get(0);

                return "modify";
            } else {

                Dao.executeSQL(Dao.U,product);
                return SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError(e.toString());
            return INPUT;
        }
    }
}
