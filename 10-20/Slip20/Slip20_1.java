//1. Create a JSP page to accept a number from a user and display it in words: Example: 123 – One Two Three. The output should be in red color. [15 M] 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <h1>Convert Number to Words</h1>
    <form method="post" action="Slip20_1.jsp">
        Enter a Number: <input type="text" name="number">
        <input type="submit" value="Convert">
    </form>
    <%-- Retrieve the input number from the request --%>
    <% 
        String numberStr = request.getParameter("number");
        if(numberStr != null && !numberStr.isEmpty()) {
            // Array to store the word representations of digits
            String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
            
            // Convert the input string to an integer
            int number = Integer.parseInt(numberStr);
            // Convert the number to words
            String numberInWords = "";
            while (number > 0) {
                int digit = number % 10;
                numberInWords = words[digit] + " " + numberInWords;
                number = number / 10;
            }
    %>
    <p>Number: <%= numberStr %></p>
    <p style="color: red;">Number in Words: <%= numberInWords.trim() %></p>
    <% } %>