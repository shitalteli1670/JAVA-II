<%@ page import="java.sql.*, java.util.*" %>
<html>
<head>
    <title>Quiz Result</title>
</head>
<body>
    <h2>Quiz Result</h2>
    <%
        int score = 0;
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "123");
        PreparedStatement pstmt = conn.prepareStatement("SELECT correct_option FROM questions WHERE id=?");
        for (int i = 1; i <= 5; i++) 
        {
            String questionId = request.getParameter("q" + i);
            String answer = request.getParameter("ans" + i);

            if (questionId != null && answer != null) 
            {
                pstmt.setInt(1, Integer.parseInt(questionId));
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) 
                {
                    int correctOption = rs.getInt("correct_option");
                    if (correctOption == Integer.parseInt(answer)) 
                    {
                        score++;
                    }
                }
                rs.close();
            }
        }
        pstmt.close();
        conn.close();
        out.println("<h3>Your Score: " + score + " / 5</h3>");
    %>
</body>
</html>