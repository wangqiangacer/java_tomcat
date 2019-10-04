package com.jacken.java_tomcat.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Optional;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("this is a tomcat");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("this is  get tomcat  starting!!!");

        String name = req.getParameter("name");

        String method = req.getMethod();
        Cookie[] cookies = req.getCookies();
        if(Optional.ofNullable(cookies).isPresent()){
            for (Cookie cookie : cookies) {
                System.out.println(cookie);
            }
        }


        String requestURI = req.getRequestURI();
        System.out.println("requestURI:"+requestURI);

        String servletPath = req.getServletPath();
        System.out.println("servletPath:"+servletPath);
        String authType = req.getAuthType();
        System.out.println("authType:"+authType);

        Enumeration<String> headerNames = req.getHeaderNames();
        System.out.println(headerNames.nextElement());

        HttpSession session = req.getSession();
        System.out.println(session);



        String contentType = req.getContentType();
        System.out.println("contentType:"+contentType);

        String localAddr = req.getLocalAddr();
        System.out.println("localAddr:"+localAddr);

        String remoteHost = req.getRemoteHost();
        System.out.println("remoteHost:"+remoteHost);


        resp.getWriter().write("reture  name is :"+name);
    }
}
