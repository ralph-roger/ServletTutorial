<%@ page import="java.util.Random,java.text.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title  in javaInHtml</title>
</head>
<body>
<h2>Hier der übergebene Parameter</h2>

Parameter para: <b><%= request.getParameter("para") %></b>

<h2>Hier eine Random-Funktion</h2>
    <%  String contextPath = request.getContextPath();
        Random random = new Random();
        // Returns a random number (0, 1 or 2)
        int randomInt = random.nextInt(3);
        if (randomInt == 0) {
    %>
    <h1>Hier der ContextPath: <%=contextPath%></h1>
    <h1>Random value =<%=randomInt%></h1>
    <%
        } else if (randomInt == 1) {
    %>
    <h2>Random value =<%=randomInt%></h2>
    <%
        } else {
    %>
     <h3>Random value =<%=randomInt%></h3>
    <%
        }
    %>
    <a href="<%= request.getRequestURI() %>">Try Again</a>
</body>
</html>