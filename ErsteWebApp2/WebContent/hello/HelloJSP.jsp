<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vom Servlet gerufen</title>
</head>
<body>
<h2>Hallo hier ist HelloJSP</h2>

<h2>Und hier hole ich eine Bean</h2>

<jsp:useBean id="xbean" class="my.MyBean">
<jsp:setProperty  name="xbean" property="name"  />
<jsp:setProperty  name="xbean" property="var"  />
</jsp:useBean>

<jsp:getProperty name="xbean" property="name" />
<br>

<h2> Jetzt getVar </h2>

<jsp:getProperty name="xbean" property="var" />
<br>
Hallo: <% String x = xbean.getVar(); 
out.print ( " hier ist " +x);
%>
<br>
aber  Hallo


</body>
</html>