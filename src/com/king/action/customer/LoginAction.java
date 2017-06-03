package com.king.action.customer;

import com.king.model.Customer;
import com.king.validation.Encrypter;
import com.king.validation.Validation;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by king on 2017/5/11.
 */
public class LoginAction  extends ActionSupport implements ServletRequestAware {
    private Customer customer;
    private javax.servlet.http.HttpServletRequest request;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }

    public String execute(){
        try {

            String p=customer.getCsrPwd();
            customer.setCsrPwd(null);
            if (!Validation.validationUser(customer,p)){
                this.addActionError("密码或用户名错误！");
                return INPUT;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError(e.toString());
            return INPUT;
        }
        javax.servlet.http.HttpSession session=request.getSession();
        session.setAttribute("id", customer.getId());
        session.setMaxInactiveInterval(60*60*3);
        return SUCCESS;
    }

}
