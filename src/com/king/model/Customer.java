package com.king.model;

/**
 * Created by king on 2017/5/10.
 */
public class Customer {
        private String id;
        private String csrPwd;
        private String csrName;
        private String csrSex;
        private String csrAddress;
        private String csrTel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCsrPwd() {
        return csrPwd;
    }

    public void setCsrPwd(String csrPwd) {
        this.csrPwd = csrPwd;
    }

    public String getCsrName() {
        return csrName;
    }

    public void setCsrName(String csrName) {
        this.csrName = csrName;
    }

    public String getCsrSex() {
        return csrSex;
    }

    public void setCsrSex(String csrSex) {
        this.csrSex = csrSex;
    }

    public String getCsrAddress() {
        return csrAddress;
    }

    public void setCsrAddress(String csrAddress) {
        this.csrAddress = csrAddress;
    }

    public String getCsrTel() {
        return csrTel;
    }

    public void setCsrTel(String csrTel) {
        this.csrTel = csrTel;
    }
}
