<%@page import="java.util.*"%>

<%

    String name = request.getParameter("uname"); // Retrieve username from the form

    Date d = new Date(); // Get the current date/time

    // Time-based greeting
    if(d.getHours() < 12) {
%>
    Good Morning <%= name %> // Morning greeting
<%
    } else if(d.getHours() < 16) {
%>
    Good Afternoon <%= name %> // Afternoon greeting
<%
    } else {
%>
    Good Evening <%= name %> // Evening greeting
<%
    }
%>

