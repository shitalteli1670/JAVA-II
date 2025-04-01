<%@ page language="java" %> 
<% 
    String username = request.getParameter("uname"); 
    String password = request.getParameter("pass");

    if (username.equals(password)) {
        response.sendRedirect("success.html");
    } else {
        response.sendRedirect("Error.html");
    }
%>
