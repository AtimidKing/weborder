package com.king.validation;

import com.king.dao.Dao;

import java.sql.ResultSet;

/**
 * Created by yking on 17-5-11.
 */
public class Validation {
//    public static<T> boolean validationadministrator(T t) throws InvocationTargetException, SQLException, IllegalAccessException, NoSuchMethodException, NamingException {
//        java.sql.ResultSet rSet= null;
//        try {
//            rSet = Dao.executeSQL(Dao.S,t);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (rSet.next()) {
//            String password_MD5=Encrypter.md5Encypter(t.getPassword());
//            if (password_MD5.equals(rSet.getString("password"))) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static<T> boolean validationUser(T t,String p) throws Exception {
        ResultSet resultSet = Dao.executeSQL(Dao.S, t);
        while (resultSet.next()){
            String password_MD5=Encrypter.md5Encypter(p);
            System.out.println("p:" +password_MD5);
            try {
                if (password_MD5.equals(resultSet.getObject("csrPwd"))) {
                    System.out.println(true);
                    return true;
                }
            }catch (java.sql.SQLException e){
                if (password_MD5.equals(resultSet.getObject("adminPwd"))) {
                    System.out.println(true);
                    return true;
                }
                return false;
            }
        }

        return false;
    }
}
