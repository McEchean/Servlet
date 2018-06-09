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

@WebServlet(name = "showCar",urlPatterns = "/showCar")
public class showCar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        LinkedHashMap<Book,Integer> ll = (LinkedHashMap<Book, Integer>) session.getAttribute("books");
        out.println("你购买了以下书籍：<hr/>");
        out.println("<table border=1px bordercolor=green width=500px>");
        out.println("<tr><th>书籍名称</th><th>数量</th><th>单价/元</th></tr>");
        int amount = 0;
        for (Book bk: ll.keySet()) {
            out.println("<tr><td>" + bk.getName() + "</td><td>" + ll.get(bk) + "</td><td>" + bk.getPrice() + "</td></tr>");
            amount += ll.get(bk) * bk.getPrice();
        }
        out.println("<tr><td>总价</td><td></td><td>" + amount + "元</td></tr><br/>");

        out.println("</table><hr/>");
        out.println("<a href=/Car/showBook>返回首页</a>");


    }
}
