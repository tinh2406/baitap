package com.controller;


import com.model.bean.Account;
import com.model.bo.AccountBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountBO accountBO = new AccountBO();
        if(accountBO.checkLogin(username,password)){
            request.getSession().setAttribute("account",accountBO.getAccountByUsername(username));
            response.sendRedirect("displayAllAccountServlet");
        }
        else
            response.sendRedirect("loginfail.jsp");

    }
}
