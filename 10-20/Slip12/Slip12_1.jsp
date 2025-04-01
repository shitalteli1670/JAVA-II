<h2>Perfect Number Checker</h2>
    <form method="post">
        Enter a number: <input type="text" name="number">
        <input type="submit" value="Check">
    </form>
    <%!
    boolean isPerfectNumber(int num) 
    {
        if (num <= 0) 
        {
            return false;
        }
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) 
        {
            if (num % i == 0) 
            {
                sum += i;
            }
        }
        return sum == num;
    }
    %>
    <% 
    if (request.getMethod().equals("POST")) 
    {
        int number = Integer.parseInt(request.getParameter("number"));
        boolean isNumberPerfect = isPerfectNumber(number);
    %>
    <p>
        The number <%= number %> is 
            <%= isNumberPerfect ? "perfect" : "not perfect" %>
    </p>
    <% } %>