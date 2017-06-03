package com.king.dao;

import com.king.model.Customer;
import org.junit.Test;
//import org.junit.Test;

//import static org.junit.Assert.*;

/**
 * Created by king on 2017/5/10.
 */
public class DaoTest {
    @Test
    public void executeSQL() throws Exception {
        Customer customer=new Customer();
        customer.setId("1112");
        customer.setCsrAddress("wu");
        customer.setCsrName("z");
        customer.setCsrPwd("2");
        customer.setCsrSex("男");
        customer.setCsrTel("11111111");
//        Dao.executeSQL(Dao.I,customer);
        boolean b=customer == null &&( 2 == 3 || 4 == 4);
        String s="s;y;z;s";
        String[] z=s.split(";");
        for (int i = 0; i < z.length; i++) {
            System.out.println(z[i]);
            System.out.println(i);
        }
        System.out.println(b);
    }

}