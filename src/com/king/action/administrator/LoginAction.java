package com.king.action.administrator;

import com.king.model.Administrator;
import com.king.validation.Validation;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by king on 2017/5/11.
 */
public class LoginAction extends ActionSupport implements ServletRequestAware{
    private Administrator administrator;
    private javax.servlet.http.HttpServletRequest request;

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
            this.request=httpServletRequest;
    }

    public String execute(){
        try {
            String p=administrator.getAdminPwd();
            administrator.setAdminPwd(null);
            if (!Validation.validationUser(administrator,p)) {
                this.addActionError("密码或用户名错误！");
                return INPUT;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError(e.toString());
            return INPUT;
        }
        javax.servlet.http.HttpSession session=request.getSession();
        session.setAttribute("id", administrator.getId());
        session.setMaxInactiveInterval(60*60*3);
        return SUCCESS;
    }

}
