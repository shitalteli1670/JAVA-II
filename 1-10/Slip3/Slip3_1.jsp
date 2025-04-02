<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Patient Details</title>
</head>
<body>
    <h2>Patient Details</h2>
    <table border="1">
        <tr>
            <th>Patient Number</th>
            <th>Name</th>
            <th>Address</th>
            <th>Age</th>
            <th>Disease</th>
        </tr>
        <%
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Patient");
            
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("PNo") %></td>
            <td><%= rs.getString("PName") %></td>
            <td><%= rs.getString("Address") %></td>
            <td><%= rs.getInt("Age") %></td>
            <td><%= rs.getString("Disease") %></td>
        </tr>
        <%
            }
        } catch (Exception e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        %>
    </table>
</body>
</html>


//command
// cd /opt/tomcat/bin
//./startup.sh
//http://localhost:8080/Slip3_1.jsp

