package com.king.action.product;

import com.king.dao.Dao;
import com.king.model.Product;
import com.king.other.Parser;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by king on 2017/5/11.
 */
public class IndexAction extends ActionSupport {
    private Product product=new Product();
    private String catagory;
    private java.util.List list;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String execute() {
        try {
            if (catagory!=null) {
                product.setProductCatagory(catagory);
            }
            list = Parser.generatePOJO(product, Dao.executeSQL(Dao.S, product));
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError(e.toString());
            return INPUT;
        }
        return SUCCESS;
    }
}
