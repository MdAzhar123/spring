<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="jsp">
 <%
   if(request.getAttribute("fName")!=null)
   {
	   String fullName=(String)request.getAttribute("fName");
	   out.print("<h2><font face='comic sans ms' color='green'>");
	   out.print("Congratulations, "+fullName+" U have successfully registered..");
	   out.print("</font></h2>");
   }
 
 %>

</body>
</html>