import java.io.*;
import java.sql.*;
import java.util.*;

class Slip30_2 
{

    public static void main(String args[]) 
    {
        
        int ch;
        Scanner s = new Scanner(System.in);

        try {
            // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");
            // Establish connection
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "123");
            // Create a statement with scrollable and updatable ResultSet
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // Execute query and get the ResultSet
            ResultSet rs = stmt.executeQuery("select * from Teacher");

            // Count the number of records in the ResultSet
            int count = 0;
            while (rs.next()) {
                count++;
            }
            System.out.println("Which Record do you want?");
            System.out.println("Total Records = " + count);

            do {
                System.out.println("1 First \n2 Last \n3 Next \n4 Previous \n0 Exit");
                ch = s.nextInt();
                switch (ch) {
                    case 1: 
                        rs.first();
                        System.out.println("Teacher Id: " + rs.getInt(1) + " Name: " + rs.getString(2) + " Salary: " + rs.getInt(3)); 
                        break;

                    case 2: 
                        rs.last();
                        System.out.println("Teacher Id: " + rs.getInt(1) + " Name: " + rs.getString(2) + " Salary: " + rs.getInt(3)); 
                        break;

                    case 3: 
                        if (rs.next()) {
                            System.out.println("Teacher Id: " + rs.getInt(1) + " Name: " + rs.getString(2) + " Salary: " + rs.getInt(3)); 
                        } else {
                            System.out.println("Can't move forward.");
                        }
                        break;

                    case 4: 
                        if (rs.previous()) {
                            System.out.println("Teacher Id: " + rs.getInt(1) + " Name: " + rs.getString(2) + " Salary: " + rs.getInt(3)); 
                        } else {
                            System.out.println("Can't move backward.");
                        }
                        break;

                    case 0:
                        break;

                    default:
                        System.out.println("Enter a valid operation.");
                }
            } while (ch != 0);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*  sudo systemctl start postgresql
sudo -u postgres psql
psql (16.8 (Ubuntu 16.8-0ubuntu0.24.04.1))
Type "help" for help.

postgres=# \c testdb
You are now connected to database "testdb" as user "postgres".
testdb=# CREATE TABLE Teacher (
    TID SERIAL PRIMARY KEY,
    TName VARCHAR(100),
    Salary INTEGER
);
CREATE TABLE
testdb=# INSERT INTO Teacher (TName, Salary) VALUES ('John Doe', 50000);
INSERT INTO Teacher (TName, Salary) VALUES ('Jane Smith', 60000);
INSERT INTO Teacher (TName, Salary) VALUES ('Alice Johnson', 55000);
INSERT 0 1
INSERT 0 1
INSERT 0 1

javac -cp ".:postgresql-42.7.5.jar" Slip30_2.java
java -cp ".:postgresql-42.7.5.jar" Slip30_2     */