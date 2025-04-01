<h2>Prime Number Checker</h2>
    <form method="post">
        Enter a number: <input type="text" name="number">
        <input type="submit" value="Check">
    </form>
    <%!
    boolean isPrime(int num) 
    {
        if (num <= 1) 
        {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) 
        {
            if (num % i == 0) 
            {
                return false;
            }
        }
        return true;
    }
    %>
    <% 
    if (request.getMethod().equals("POST")) 
    {
        int number = Integer.parseInt(request.getParameter("number"));
        boolean isNumberPrime = isPrime(number);
    %>
    <h2 style="color: red;">
        <%= number %> is <%= isNumberPrime ? "a Prime Number" : "Not a Prime Number" %>
    </h2>  
    <% } %>

