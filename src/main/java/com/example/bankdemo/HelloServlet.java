package com.example.bankdemo;

import DomæneObjekter.Konto;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet
{
    Map<String, Konto> kontoMap = new TreeMap<>();


    public void init()
    {
        Konto konto = new Konto("markus","1", 100);
        Konto konto1 = new Konto("sebastian","1", 100);
        Konto konto2 = new Konto("timmi","1", 100);
        Konto konto3 = new Konto("march","1", 100);
        Konto konto4 = new Konto("patrick","1", 100);
        Konto konto5 = new Konto("otto","1", 100);
        Konto konto6 = new Konto("maria","1", 100);
        Konto konto7 = new Konto("nicki","1", 100);
        Konto konto8 = new Konto("micki","1", 100);
        Konto konto9 = new Konto("nikolaj","1", 100);

        kontoMap.put(konto.getNavn(), konto);
        kontoMap.put(konto1.getNavn(), konto1);
        kontoMap.put(konto2.getNavn(), konto2);
        kontoMap.put(konto3.getNavn(), konto3);
        kontoMap.put(konto4.getNavn(), konto4);
        kontoMap.put(konto5.getNavn(), konto5);
        kontoMap.put(konto6.getNavn(), konto6);
        kontoMap.put(konto7.getNavn(), konto7);
        kontoMap.put(konto8.getNavn(), konto8);
        kontoMap.put(konto9.getNavn(), konto9);

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("kontis",kontoMap );

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
         request.getRequestDispatcher("index.jsp").forward(request , response);


    }

    public void destroy()
    {
    }
}