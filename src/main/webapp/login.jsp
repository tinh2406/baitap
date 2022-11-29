<%@ page import="com.model.bean.Account" %><%--
  Created by IntelliJ IDEA.
  User: NQT
  Date: 11/28/2022
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%
    Account account = (Account) session.getAttribute("account");
    if(account!=null)
        response.sendRedirect("displayAllAccountServlet");
%>
<form action="loginServlet" method="post">
    <br>Username     <input type="text" name="username" id="username">
    <br>Password      <input type="text" name="password" id="password">
  <input type="submit" value="Login">
</form>
</body>
</html>
