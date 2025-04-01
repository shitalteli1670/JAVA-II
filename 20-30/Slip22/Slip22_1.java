import java.sql.*;
import java.util.*;

public class Slip22_1 
{
    public static void main(String[] args) 
    {
        Connection con;
        ResultSet rs;
        Statement t;
        PreparedStatement ps;
        Scanner s = new Scanner(System.in);

        try 
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "123");
            
            while (true) 
            {
                System.out.println("\n1. Insert\n2. Update\n3. Display\n4. Exit");
                System.out.print("Enter your choice: ");
                int ch = s.nextInt();

                switch (ch) 
                {
                    case 1:
                        System.out.print("Enter Employee Number: ");
                        int eno = s.nextInt();
                        System.out.print("Enter Employee Name: ");
                        String ename = s.next();
                        System.out.print("Enter Salary: ");
                        int sal = s.nextInt();
                        
                        ps = con.prepareStatement("INSERT INTO emp VALUES (?, ?, ?)");
                        ps.setInt(1, eno);
                        ps.setString(2, ename);
                        ps.setInt(3, sal);
                        ps.executeUpdate();
                        System.out.println("Record Inserted Successfully!");
                        break;
                    
                    case 2:
                        System.out.print("Enter Employee Number to update: ");
                        int eno1 = s.nextInt();
                        System.out.print("Enter New Employee Name: ");
                        String ename1 = s.next();
                        System.out.print("Enter New Salary: ");
                        int sal1 = s.nextInt();
                        
                        ps = con.prepareStatement("UPDATE emp SET ename=?, salary=? WHERE empid=?");
                        ps.setString(1, ename1);
                        ps.setInt(2, sal1);
                        ps.setInt(3, eno1);
                        ps.executeUpdate();
                        System.out.println("Record Updated Successfully!");
                        break;
                    
                    case 3:
                        t = con.createStatement();
                        rs = t.executeQuery("SELECT * FROM emp");
                        System.out.println("\nEmployee Number\tEmployee Name\tSalary");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
                        }
                        break;
                    
                    case 4:
                        System.out.println("Exiting Program...");
                        System.exit(0);
                        break;
                    
                    default:
                        System.out.println("Invalid Choice. Please try again.");
                }
            }
        } catch (Exception e) 
        {
            System.out.println("Error: " + e);
        }
    }
}

/*  sudo -u postgres psql
create database testdb;
\c testdb
sudo systemctl start postgresql
javac -cp ".:postgresql-42.7.5.jar" Slip22_1.java
java -cp ".:postgresql-42.7.5.jar" Slip22_1     */
