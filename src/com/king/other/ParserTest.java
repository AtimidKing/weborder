package com.king.other;

import com.king.dao.Dao;
import com.king.model.Book;
//import org.junit.Test;

import java.util.*;

//import static org.junit.Assert.*;

/**
 * Created by king on 2017/5/8.
 */
public class ParserTest {
//    @Test
    public void generatePOJO() throws Exception {
        Book book = new Book();
        book.setId(1111);
        book.setName("yang");
        book.setAddress("无");
        book.setAuthor("z");
        book.setPublishunit("l");
        book.setSort("y");
        Map<String, Object> map = new HashMap<>();
        map.put("table", "Book");
        map.put("sort", "y");
        map.put("id", 1111);
        map.put("name", "yang");
        map.put("address", "无");
        map.put("author", "z");
        map.put("publishunit", "l");
        map.put("publishdate", null);
//        assertEquals(Parser.parsePOJO(book), map);
//        assertEquals(Parser.generateSQL(Dao.I, book).trim().toString(), "INSERT INTO Book ( " +
//                " address,author,name,id,sort,publishunit ) VALUES( ?,?,?,?,? )".trim().toString());
//        assertEquals(Parser.generateSQL(Dao.U, book).trim(), "UPDATE Book SET address=?,author=?,name=?,sort=?,publishunit=? WHERE id=?".trim());
//        assertEquals(Parser.generateSQL(Dao.S, book).trim(), "SELECT address,author,name,id,sort,publishunit FROM Book WHERE " +
//                " 1=1  AND address=? AND author=? AND name=? AND id=? AND sort=? AND publishunit=?".trim());
//        assertEquals(Parser.generateSQL(Dao.D, book).trim(), "DELETE FROM Book WHERE id=?".trim());
    }


//    @Test
    public void methodTest() {
        String a = "yang gao ni hao !";
        System.out.println(a.equals("yang gao ni hao !"));
        System.out.println(a.replace("gao", ""));
        String b = null;
        System.out.println(a.contains("gao"));
        System.out.println(b == null);
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        java.util.Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

//    @Test
    public void nullPointE() {
        java.util.Map map = new HashMap();
        java.lang.StringBuilder condition = new StringBuilder();
        map.put("publishdate", null);
//        map.forEach((k, v) -> condition.append(v.toString() + k.toString() + "=" + "?"));
        System.out.println(map.isEmpty());
        System.out.println(condition);
        System.out.println();
    }

}