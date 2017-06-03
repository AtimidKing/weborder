package com.king.action.customer;

import com.king.dao.Dao;
import com.king.model.Customer;
import com.king.validation.Encrypter;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by king on 2017/5/11.
 */
public class RegisterAction  extends ActionSupport{
    private Customer customer;
    private String rePassword;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
    public String execute(){
        System.out.println(customer.getCsrPwd());
        System.out.println(rePassword);
        if (rePassword.toString()==customer.getCsrPwd().toString()) {
            this.addActionError("两次密码不一致");
            return INPUT;
        }
        try {
            System.out.println(customer.getCsrPwd());
            customer.setCsrPwd(Encrypter.md5Encypter(customer.getCsrPwd()));
            Dao.executeSQL(Dao.I,customer);
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError(e.toString());
            return INPUT;
        }
        return SUCCESS;
    }
}
