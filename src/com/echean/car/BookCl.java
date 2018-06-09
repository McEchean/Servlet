package com.echean.car;

import com.echean.mianp.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import static com.echean.mianp.db.getBookById;

@WebServlet(name = "BookCl",urlPatterns = "/BookCl")
public class BookCl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        String id = request.getParameter("id");

        Object a = session.getAttribute("books");
        if(a == null) {
            LinkedHashMap<Book,Integer> list = new LinkedHashMap<>();
            session.setAttribute("books",list);
            if(!"".equals(id)) {
                Book bk1 = getBookById(Integer.parseInt(id));
                if(bk1 != null) {
                    if(!list.containsKey(bk1)) {
                        list.put(bk1,1);
                    }else {
                        list.put(bk1,list.get(bk1) + 1);
                    }
                }
            }
        }else {
            LinkedHashMap<Book,Integer> oldlist = (LinkedHashMap<Book, Integer>) a;
            if(!"".equals(id)) {
                Book bk1 = getBookById(Integer.parseInt(id));
                if(bk1 != null) {
                    if(!oldlist.containsKey(bk1)) {
                        oldlist.put(bk1,1);
                    }else {
                        oldlist.put(bk1,oldlist.get(bk1) + 1);
                    }
                }
            }
        }
        request.getRequestDispatcher("/showCar").forward(request,response);
    }
}
