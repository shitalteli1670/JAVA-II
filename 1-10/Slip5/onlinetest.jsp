<%@ page import="java.sql.*, java.util.*" %>
<html>
<head>
    <title>Online Quiz</title>
</head>
<body>
    <h2>Online Multiple Choice Test</h2>
    <form action="result.jsp" method="post">
        <%
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "123");
            Statement stmt = conn.createStatement();
            // Select 5 random questions
            String sql = "SELECT * FROM questions ORDER BY RANDOM() LIMIT 5";
            ResultSet rs = stmt.executeQuery(sql);
            int i = 1;
            while (rs.next()) {
                int id = rs.getInt("id");
                String question = rs.getString("question");

                String option1 = rs.getString("option1");

                String option2 = rs.getString("option2");

                String option3 = rs.getString("option3");

                String option4 = rs.getString("option4");


                out.println("<p>" + i + ". " + question + "</p>");

                out.println("<input type='hidden' name='q" + i + "' value='" + id + "'>");

                out.println("<input type='radio' name='ans" + i + "' value='1'>" + option1 + "<br>");

                out.println("<input type='radio' name='ans" + i + "' value='2'>" + option2 + "<br>");

                out.println("<input type='radio' name='ans" + i + "' value='3'>" + option3 + "<br>");

                out.println("<input type='radio' name='ans" + i + "' value='4'>" + option4 + "<br><br>");

                i++;

            }


            rs.close();

            stmt.close();

            conn.close();

        %>

        <input type="submit" value="Submit">

    </form>

</body>

</html>