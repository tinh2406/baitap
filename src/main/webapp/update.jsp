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
    <title>Update</title>
</head>
<body>
<%
    Account account = (Account) session.getAttribute("account");
    if(account==null)
        response.sendRedirect("loginServlet");
%>
<h1 style="width: 100vw;text-align: center">Welcome, <%=account.firstname%> </h1>
<%
    Account account_update = (Account) request.getAttribute("account");
    if(account_update==null)
        response.sendRedirect("displayServlet");
%>
<form action="updateAccountServlet?id=<%=account_update.getId()%>" method="post">
    <br>Firstname    <input type="text" name="firstname" id="firstname" value="<%=account_update.firstname%>">
    <br>Lastname     <input type="text" name="lastname" id="lastname" value="<%=account_update.lastname%>">
    <br>Role         <select name="role" id="role">
    <option value="True" <%=account_update.role?"selected":""%>>Admin</option>
    <option value="False" <%=account_update.role?"":"selected"%>>User</option>
</select>
    <input type="submit" value="Update">
</form>
</body>
</html>
