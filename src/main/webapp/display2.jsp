<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.*" %>
    <%@ page  import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Order</title>
</head>
<body>

<%List<Purchesed> e=(List<Purchesed>)request.getAttribute("list");
%>

<table  border="1">
<tr><th>Purchased Id</th><th>User name</th><th>Product Name</th><th>Product Cost</th></tr>
<%for(Purchesed ee:e){ %>
<tr><td><%=ee.getId()%></td><td><%=ee.getUser() %></td><td><%=ee.getPname() %></td><td><%=ee.getCost() %></td></tr>
<%} %>
</table>
</body>
</html>