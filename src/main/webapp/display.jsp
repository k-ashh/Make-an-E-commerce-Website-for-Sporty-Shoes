<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.*" %>
    <%@ page  import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>

<%List<Product> e=(List<Product>)request.getAttribute("list");
%>

<table  border="1">
<tr><th>Product Id</th><th>product name</th><th>Cost</th><th>Edit operation</th><th>Delete operation</th></tr>
<%for(Product ee:e){ %>
<tr><td><%=ee.getPid()%></td><td><%=ee.getPname() %></td><td><%=ee.getCost() %></td><td><a href="edit.jsp">Edit</a></td><td><a href="delete.jsp">Delete by id</a></td></tr>
<%} %>
</table>
</body>
</html>