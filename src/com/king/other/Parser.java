package com.king.other;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by yking on 2017/5/6.
 */
public class Parser {


    /**
     * 将结果集转化为对应的POJO对象。
     *
     * @param pojo      目标对象。
     * @param resultSet 所需结果集。
     * @return 返回目标对象集合。
     */
    public static <P> List generatePOJO(P pojo, ResultSet resultSet) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException, InstantiationException {
        List<P> list = new ArrayList<P>();
        Class c = pojo.getClass();
        Field[] fields = c.getDeclaredFields();//获取成员对象列表
        while (resultSet.next()) {
            Object object = c.newInstance();
            for (int i = 0; i < fields.length; i++) {
                String key = fields[i].getName();//获取成员对象名称
                Method method = c.getDeclaredMethod(setMethodName(key),fields[i].getType());//获取成员对象方法
                method.invoke(object, getResultSetValue(fields[i], resultSet));//执行方法。
            }
            list.add((P) object);
        }
        return list;
    }

    /**
     * 获取结果集中的值便将其转换为相应的类型。
     *
     * @param field     域，类的成员变量。
     * @param resultSet 需要取值的结果集。
     * @return 返回相应的类型的对象。
     */
    private static Object getResultSetValue(Field field, ResultSet resultSet) throws IllegalAccessException, InstantiationException, SQLException {
        Class fieldType = field.getType();
        Object object = resultSet.getObject(field.getName());
        return fieldType.cast(object);

    }

    private static String setMethodName(String key) {
        return "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
    }

    /**
     * 解析POJO类，将其解析为键值对。
     *
     * @param pojo 一个POJO类。
     * @return 返回一组键值对。key为该POJO的成员变量名。value为该对象的成员变量对应的值。
     */
    public static <P> Map<String, Object> parsePOJO(P pojo) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class c = pojo.getClass();
        map.put("table", c.getSimpleName());
        Field[] fields = c.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String key = fields[i].getName();
            map.put(key, getValue(key, pojo));
        }
        return map;
    }


    /**
     * 获取成员变量的值。
     *
     * @param key  成员变量的名称。
     * @param pojo 成员变量所属的对象。
     */
    private static <P> Object getValue(String key, P pojo) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = pojo.getClass();
        Method method = c.getDeclaredMethod(getMethodName(key));
        Object value = method.invoke(pojo);
        return value;
    }

    /**
     * 拼接对应成员变量的get方法名。
     *
     * @param key 成员变量名称。
     */

    private static String getMethodName(String key) {
        return "get" + key.substring(0, 1).toUpperCase() + key.substring(1);
    }

    /**
     * 生成可执行的PreparedStatement对象。
     *
     * @param operation  执行的操作
     * @param connection 数据库里连接对象。
     * @param t          添加到数据库的POJO对象。
     * @return 可执行的PreparedStatement对象。
     */

    public static <T> java.sql.PreparedStatement generateSQL(int operation, java.sql.Connection connection, T t) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, SQLException {
        Map map = parsePOJO(t);
        switch (operation) {
            case 0:
                return getInsert(map, connection);
            case 1:
                return getUpdate(map, connection);
            case 2:
                return getSelect(map, connection);
            case 3:
                return getDelete(map, connection);
        }
        return null;
    }

    private static java.sql.PreparedStatement getDelete(Map map, java.sql.Connection connection) throws SQLException {
        String sql1 = "DELETE FROM" + map.get("table").toString();
        String sql2 = " WHERE 1=1";
        java.util.List<String> values = new ArrayList<>();

        java.util.Set keySet = map.keySet();
        java.util.Iterator iterator = keySet.iterator();
        int j = -1;
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (key.equals("table")) {
                continue;
            }
            String value = map.get(key).toString();
            if (value.isEmpty()) {
                sql1 += "and" + key + "=";
                sql2 += "?";
                values.add(value);
            }
        }
        String sql = sql1 + sql2;
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < values.size(); i++) {
            preparedStatement.setObject(i + 1, values.get(i));
        }
        return preparedStatement;
    }

    private static java.sql.PreparedStatement getSelect(Map map, java.sql.Connection connection) throws SQLException {
        String sql1 = "SELECT ";
        String sql2 = " WHERE 1=1";
        java.util.List<String> values = new ArrayList<>();

        java.util.Set keySet = map.keySet();
        java.util.Iterator iterator = keySet.iterator();
        int j = -1;
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (key.equals("table")) {
                continue;
            }
            String value = map.get(key).toString();
            if (value.isEmpty()) {
                sql1 += "and" + key + "=";
                sql2 += "?";
                values.add(value);
            }
        }
        String sql = sql1 + "from" + map.get("table").toString() + sql2;
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < values.size(); i++) {
            preparedStatement.setObject(i + 1, values.get(i));
        }
        return preparedStatement;
    }

    private static java.sql.PreparedStatement getUpdate(Map map, java.sql.Connection connection) throws SQLException {
        String sql1 = "UPDATE " + map.get("table").toString() + " SET ";
        String sql2 = " WHERE 1=1 AND id=?";
        java.util.List<String> values = new ArrayList<>();

        java.util.Set keySet = map.keySet();
        java.util.Iterator iterator = keySet.iterator();
        int j = -1;
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (key.equals("table") || key.equals("id")) {
                continue;
            }
            String value = map.get(key).toString();
            if (value.isEmpty()) {
                sql1 += "and" + key + "=?";
                values.add(value);
            }
        }
        values.add(map.get("id").toString());
        String sql = sql1 + map.get("table").toString() + sql2;
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < values.size(); i++) {
            preparedStatement.setObject(i + 1, values.get(i));
        }
        return preparedStatement;
    }

    private static java.sql.PreparedStatement getInsert(Map map, java.sql.Connection connection) throws SQLException {
        String sql1 = "INSERT INTO" + map.get("table").toString() + " (`id`,`name`,`email`)";
        String sql2 = " VALUES(";
        String[] values = new String[map.size() - 1];

        java.util.Set keySet = map.keySet();
        java.util.Iterator iterator = keySet.iterator();
        int j = -1;
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (key.equals("table")) {
                continue;
            }
            sql1 += key + ",";
            sql2 += "?,";
            values[j + 1] = map.get(key).toString();
        }
        String sql = sql1.substring(0, sql1.length() - 1) + ") " + sql2.substring(0, sql2.length() - 1) + ")";
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < map.size() - 1; i++) {
            preparedStatement.setObject(i + 1, values[i]);
        }
        return preparedStatement;
    }


    public static <T> String generateSQL(int operation, T t) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Map map = parsePOJO(t);
        String insert = "INSERT INTO table ( field ) VALUES( value )";
        String update = "UPDATE table SET value WHERE condition";
        String delete = "DELETE FROM table WHERE condition";
        String search = "SELECT field FROM table WHERE 1=1 condition";
        switch (operation) {
            case 0://insert
                return getSQL(insert, map);
            case 1://update
                return getSQL(update, map);
            case 2://select
                return getSQL(search, map);
            case 3://delete
                return getSQL(delete, map);
        }
        return null;
    }

    private static String getSQL(String sql, Map map) {
        if (!sql.contains("SELECT")) {
            map = removeNullValue(map);
        }
        //1.替换table
        sql = sql.replace("table","`"+ map.get("table").toString()+"`");
        map.remove("table");
        //2.替换field
        java.util.Set keys = map.keySet();
        java.util.Iterator iterator = keys.iterator();
        StringBuilder newField = new StringBuilder();
        while (iterator.hasNext()) {
            newField.append(iterator.next().toString());
            newField.append(",");
        }
        if (newField.length() > 0) {
            newField.deleteCharAt(newField.length() - 1);
            sql = sql.replace("field", newField.toString());
        }else {
            sql = sql.replace("field", "*");
        }
        //3.替换value
        StringBuilder value = new StringBuilder();
        if (sql.contains("UPDATE")) {
            map.forEach((k, v) -> value.append(k.toString().contains("id") ? "" : k.toString() + "=" + "?,"));
        } else {
            for (int i = 0; i < map.size(); i++) {
                value.append("?");
                value.append(",");
            }
        }
        if (value.length() > 0) {
            value.deleteCharAt(value.length() - 1);
            sql = sql.replace("value", value.toString());
        }
        //4.替换condition
        StringBuilder condition = new StringBuilder();
        if (sql.contains("DELETE")) {
            map.forEach((k, v) -> condition.append(k.toString().contains("id") ? k.toString() + "=" + "?" : ""));
            sql = sql.replace("condition", condition.toString());
        } else if (sql.contains("UPDATE")) {
            map.forEach((k, v) -> condition.append(k.toString().contains("id") ? k.toString() + "=" + "?" : ""));
            sql = sql.replace("condition", condition.toString());
        } else if (sql.contains("SELECT")) {
            if (map.isEmpty()) {
                sql = sql.replace("WHERE 1=1 condition", "");
            } else {
                map = removeNullValue(map);
                map.forEach((k, v) -> condition.append(" AND " + k.toString() + "=" + "?"));
                sql = sql.replace("condition", condition.toString());
            }
        }
        System.out.println(sql);
        return sql;
    }

    /**
     * 过滤掉map中的值为空的记录。
     *
     * @param map 要过滤的map对象。
     * @return 返回一个没有空值的map对象。
     */
    private static Map removeNullValue(Map map) {

        java.util.Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object value = map.get(key);
            if (value == null) {
                iterator.remove();
            }
        }
        return map;
    }
}
