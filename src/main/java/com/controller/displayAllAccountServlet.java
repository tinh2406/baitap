package com.controller;

import com.model.bo.AccountBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "displayAllAccountServlet", value = "/displayAllAccountServlet")
public class displayAllAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountBO accountBO = new AccountBO();
        request.setAttribute("allacount",accountBO.getAllAccounts());
        request.getRequestDispatcher("display.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
