<%@ page import="com.model.bean.Account" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<%
    Account account = (Account) session.getAttribute("account");
    if(account==null)
        response.sendRedirect("loginServlet");

%>


</body>
</html>