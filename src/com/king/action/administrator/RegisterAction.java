package com.king.action.administrator;

import com.king.dao.Dao;
import com.king.model.Administrator;
import com.king.validation.Encrypter;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by king on 2017/5/11.
 */
public class RegisterAction extends ActionSupport {
    private Administrator administrator;
    private String rePassword;

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public String execute(){
        if (rePassword.toString()==administrator.getAdminPwd().toString()) {
            this.addActionError("两次密码不一致");
            return INPUT;
        }
        try {
        administrator.setAdminPwd(Encrypter.md5Encypter(administrator.getAdminPwd()));
            Dao.executeSQL(Dao.I,administrator);
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError(e.toString());
            return INPUT;
        }
        return SUCCESS;
    }
}
