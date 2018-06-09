package com.echean.car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "showBook",urlPatterns = "/showBook")
public class showBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        out.println("java<a href='/Car/BookCl?id=1'>点击购买</a><br/>");
        out.println("oracle<a href='/Car/BookCl?id=2'>点击购买</a><br/>");
        out.println("C++<a href='/Car/BookCl?id=3'>点击购买</a><br/>");
        out.println("Python<a href='/Car/BookCl?id=4'>点击购买</a><br/>");

    }
}
