package com.controller;

import com.model.bo.AccountBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteAccountServlet", value = "/deleteAccountServlet")
public class deleteAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountBO accountBO = new AccountBO();
        int id = Integer.parseInt(request.getParameter("id"));
        accountBO.deleteAccount(id);
        request.getRequestDispatcher("displayAllAccountServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
