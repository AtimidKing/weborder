package com.king.action.customer;

import com.king.dao.Dao;
import com.king.model.Customer;
import com.king.other.Parser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by king on 2017/5/17.
 */
public class UpdateAction extends ActionSupport {
    private Customer customer;
    private String id;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String execute() {
        try {
            if (customer == null) {
                ActionContext actionContext = ActionContext.getContext();
                java.util.Map<String, Object> session = actionContext.getSession();
                String cId = (String) session.get("id");
                customer=new Customer();
                customer.setId(cId);
                java.util.List list = Parser.generatePOJO(customer, Dao.executeSQL(Dao.S, customer));
                customer = (Customer) list.get(0);

                return "modify";
            } else {

                Dao.executeSQL(Dao.U,customer);
                return SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError(e.toString());
            return INPUT;
        }
    }

}
