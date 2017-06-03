package com.king.dao;

import com.king.other.Parser;

import javax.naming.NamingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * Created by king on 2017/5/8.
 */
public class Dao {
    private static java.sql.Connection con;
    public static final int I = 0;//insert
    public static final int U = 1;//update
    public static final int S = 2;//select
    public static final int D = 3;//delete

    public static <T> java.sql.ResultSet executeSQL(int operation, T t, Object... args) throws Exception {
        java.sql.PreparedStatement pStatement;
        try {
            openConnect();
            pStatement = con.prepareStatement(Parser.generateSQL(operation, t));
            java.util.Map map = Parser.parsePOJO(t);
            int i = 0;
            for (Object key : map.keySet()) {
                if (map.get(key) == null && (operation == S || operation == D||operation == U||operation == I)) {
                    continue;
                }
                if (key.toString().equals("table")) {
                    continue;
                }
                if (key.toString().equals("id")&& operation == U) {
                    continue;
                }
                if (map.get(key) == null && operation == I ) {
                    map.put(key, "null");
                }
                pStatement.setObject(i = i + 1, map.get(key));
                System.out.println(map.get(key));
                System.out.println(i + ":" + map.get(key).toString());
            }
            if (operation==U) {
                pStatement.setObject(i = i + 1,map.get("id"));
                System.out.println(i + ":" + map.get("id").toString());
            }
            pStatement.execute();
            return pStatement.getResultSet();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new java.lang.Exception("1服务器压力大，出错了");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new java.lang.Exception("2服务器压力大，出错了");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new java.lang.Exception("3服务器压力大，出错了");

        } catch (NamingException e) {
            e.printStackTrace();
            throw new java.lang.Exception("4服务器压力大，出错了");

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
            throw new java.lang.Exception("商品编号已经存在");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static java.sql.ResultSet executeSQL(String sql,Object... objects) throws SQLException, NamingException {
        openConnect();
        java.sql.PreparedStatement pStatement = con.prepareStatement(sql);
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
            pStatement.setObject(i + 1, objects[i]);
        }
        pStatement.execute();
        return pStatement.getResultSet();
    }

    private static void openConnect() throws NamingException, SQLException {
        if (con == null) {
            javax.naming.Context context = new javax.naming.InitialContext();
            javax.sql.DataSource dataSource = (javax.sql.DataSource) context.lookup("java:/comp/env/jdbc/lmsDB");
            con = dataSource.getConnection();
        }
    }

}
