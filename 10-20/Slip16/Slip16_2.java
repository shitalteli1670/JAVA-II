import java.sql.*;
import java.util.*;

public class Slip16_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "123");
            
            System.out.println("Enter how many records you want to insert: ");
            int n = s.nextInt();
            
            for (int i = 0; i < n; i++) {
                System.out.println("Enter details for Teacher " + (i + 1) + ":");
                System.out.print("Enter Teacher ID: ");
                int tno = s.nextInt();
                
                System.out.print("Enter Teacher Name: ");
                String name = s.next();
                
                System.out.print("Enter Teacher Subject: ");
                String subject = s.next();
                
                PreparedStatement ps = con.prepareStatement("INSERT INTO teacher VALUES (?, ?, ?)");
                ps.setInt(1, tno);
                ps.setString(2, name);
                ps.setString(3, subject);
                ps.executeUpdate();
            }
            
            System.out.println("\nTeachers who teach JAVA:");
            System.out.println("Teacher Number\tTeacher Name\tSubject");
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM teacher WHERE subject='JAVA'");
            
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
            }
            
            s.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
