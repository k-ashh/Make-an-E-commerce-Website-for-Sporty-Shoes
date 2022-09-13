<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.*" %>
    <%@ page  import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Product</title>
</head>
<body>

<%List<Product> e=(List<Product>)request.getAttribute("list");
%>

<table  border="1">
<tr><th>Product Id</th><th>product name</th><th>Cost</th><th>Buy Option</th></tr>
<%for(Product ee:e){ %>
<tr><td><%=ee.getPid()%></td><td><%=ee.getPname() %></td><td><%=ee.getCost() %></td><td><a href="buy.jsp">Buy</a></td></tr>
<%} %>
</table>
</body>
</html>