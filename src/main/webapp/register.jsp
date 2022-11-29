<%@ page import="com.model.bean.Account" %><%--
  Created by IntelliJ IDEA.
  User: NQT
  Date: 11/28/2022
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<%
  Account account = (Account) session.getAttribute("account");
  if(account!=null)
    response.sendRedirect("index.jsp");
%>
<form action="registerServlet" method="post">
  <br>Username     <input type="text" name="username" id="username">
  <br>Password     <input type="text" name="password" id="password">
  <br>Firstname    <input type="text" name="firstname" id="firstname">
  <br>Lastname     <input type="text" name="lastname" id="lastname">
  <br>Role         <select name="role" id="role">
    <option value="True">Admin</option>
    <option value="False">User</option>
  </select>

  <input type="submit" value="Register">
</form>
</body>
</html>
