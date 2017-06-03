package com.king.action.shopbasket;

import com.king.dao.Dao;
import com.king.model.Product;
import com.king.model.ShopProduct;
import com.king.other.Parser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by king on 2017/5/15.
 */
public class IndexAction extends ActionSupport {
    private ShopProduct shopProduct;
    private java.util.List<ShopProduct> list;
    private String removeall="全部删除";

    public String getRemoveall() {
        return removeall;
    }

    public void setRemoveall(String removeall) {
        this.removeall = removeall;
    }

    public ShopProduct getShopProduct() {
        return shopProduct;
    }

    public void setShopProduct(ShopProduct shopProduct) {
        this.shopProduct = shopProduct;
    }

    public List<ShopProduct> getList() {
        return list;
    }

    public void setList(List<ShopProduct> list) {
        this.list = list;
    }

    public String execute() {
        list=new ArrayList<>();
        String basket = "";
        ActionContext actionContext = ActionContext.getContext();
        java.util.Map<String, Object> sessionMap = actionContext.getSession();
        if (sessionMap.containsKey("shopBasket")) {
            basket = sessionMap.get("shopBasket").toString();
        }
        if ((basket.equals(""))) {
            removeall="";
            return SUCCESS;
        }
        String[] products = basket.split(";");
        try {
            for (int i = 0; i < products.length; i++) {
                System.out.println(products[i]);
                String[] p = products[i].split(",");
                if (p[0]!="") {
                    ShopProduct sProduct=new ShopProduct();
                    sProduct.setId(p[0]);
                    sProduct.setNumber(p[1]);
                    Product product = new Product();
                    product.setId(sProduct.getId());
                    product = (Product) Parser.generatePOJO(product, Dao.executeSQL(Dao.S, product)).get(0);
                    sProduct.setDescribe(product.getProductDescribe());
                    sProduct.setImage(product.getProductPicture());
                    sProduct.setName(product.getProductName());
                    list.add(sProduct);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
}
