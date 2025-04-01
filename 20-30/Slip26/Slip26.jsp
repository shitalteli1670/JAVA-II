<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Sum of First and Last Digit</title>
</head>
<body>

    <h1>Calculate Sum of First and Last Digit</h1>

    <form method="post" action="Slip26.jsp">
        Enter a Number: <input type="text" name="number">
        <input type="submit" value="Calculate">
    </form>

    <% 
        // Retrieve the input number from the request
        String numberStr = request.getParameter("number");

        if (numberStr != null && !numberStr.isEmpty()) {
            // Convert the input string to an integer
            int number = Integer.parseInt(numberStr);

            // Calculate the sum of the first and last digits
            int lastDigit = number % 10;
            int firstDigit = 0;
            while (number != 0) {
                firstDigit = number % 10;
                number = number / 10;
            }
            int sum = firstDigit + lastDigit;
    %>

    <p>Number: <%= numberStr %></p>
    <p>First Digit: <%= firstDigit %></p>
    <p>Last Digit: <%= lastDigit %></p>
    <p style="color: red; font-size: 18px;">Sum of First and Last Digit: <%= sum %></p>

    <% } %>

</body>
</html>
