import java.sql.*;

public class Slip26_1 {
    public static void main(String[] args) {
        try {
            // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");

            // Establish connection to the database
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "123");

            // Get employee ID from command line arguments
            int empno = Integer.parseInt(args[0]);

            // Prepare SQL DELETE statement
            PreparedStatement ps = con.prepareStatement("DELETE FROM emp WHERE empid=?");
            ps.setInt(1, empno);

            // Execute the delete query
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("No record found with Employee ID: " + empno);
            }

            // Close resources
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

/*  sudo /opt/tomcat/bin/shutdown.sh
sudo /opt/tomcat/bin/startup.sh
javac -cp ".:postgresql-42.7.5.jar" Slip26_1.java
java -cp ".:postgresql-42.7.5.jar" Slip26_1 101
*/