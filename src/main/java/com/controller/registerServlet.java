package com.controller;

import com.model.bean.Account;
import com.model.bo.AccountBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        boolean role = Boolean.parseBoolean(request.getParameter("role"));

        AccountBO accountBO = new AccountBO();
        if(!accountBO.addNewAccount(new Account(username,password,firstname,lastname,role))){
            request.getSession().setAttribute("account",accountBO.getAccountByUsername("username"));
            request.getRequestDispatcher("displayAllAccountServlet").forward(request,response);
        }
        else
            response.sendRedirect("index.jsp");
    }
}
