<%@ page import="java.util.List" %>
<%@ page import="com.model.bean.Account" %><%--
  Created by IntelliJ IDEA.
  User: NQT
  Date: 11/28/2022
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
</head>
<body>
  <%
    Account account = (Account) session.getAttribute("account");
    if(account==null)
      response.sendRedirect("loginServlet");
    %>
  <h1 style="width: 100vw;text-align: center">Welcome, <%=account.firstname%> </h1>
  <table border="1">

  <%
    List<Account> accounts = (List<Account>) request.getAttribute("allacount");
    if(accounts.size()!=0){
      for(Account i:accounts){
  %>
  <tr>
    <td><%=i.firstname%></td>
    <td><%=i.lastname%></td>
    <td><%=!i.role?"User":"Admin"%></td>
    <td><a href="deleteAccountServlet?id=<%=i.getId()%>">Xóa</a></td>
    <td><a href="updateAccountServlet?id=<%=i.getId()%>">Cập nhật</a></td>
  </tr>
  <% } } %>
</table>

</body>
</html>
