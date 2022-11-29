package com.controller;

import com.model.bean.Account;
import com.model.bo.AccountBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updateAccountServlet", value = "/updateAccountServlet")
public class updateAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountBO accountBO = new AccountBO();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("account",accountBO.getAccountById(id));
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        boolean role = Boolean.parseBoolean(request.getParameter("role"));

        AccountBO accountBO = new AccountBO();
        if(!accountBO.updateAccount(new Account(id,username,password,firstname,lastname,role))){
            request.getRequestDispatcher("displayAllAccountServlet").forward(request,response);
        }
        else
            response.sendError(404,"Can't update");
    }
}
