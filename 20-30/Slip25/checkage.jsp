<%@ page language="java" %>
<%
    String name = request.getParameter("uname");
    int age = Integer.parseInt(request.getParameter("age"));

    if (age >= 18) {
        out.println("<h2>" + name + " is eligible for voting.</h2>");
    } else {
        out.println("<h2>" + name + " is not eligible for voting.</h2>");
    }
%>
