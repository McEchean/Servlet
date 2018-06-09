package com.echean.mianp;


import java.util.HashMap;

public class db {
    private static HashMap<Integer, Book> DB = new HashMap<>();
    private  db() {}
    static  {
        Book book1 = new Book("java", 98);
        Book book2 = new Book("oracle",67);
        Book book3 = new Book("C++",89);
        Book book4 = new Book("Python",89);
        DB.put(1,book1);
        DB.put(2,book2);
        DB.put(3,book3);
        DB.put(4,book4);
    }

    private void db(){}

    public static Book getBookById(int id) {
        if(DB.containsKey(id)) {
            return DB.get(id);
        }else {
            return null;
        }
    }

    public static boolean addRecord(Book book) {
        int len = DB.size();
        try {
            DB.put(len,book);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }




}
