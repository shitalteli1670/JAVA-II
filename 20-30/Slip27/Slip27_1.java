import javax.swing.*;
import java.sql.*;

public class Slip27_1 extends JFrame {

    public Slip27_1() {
        try {
            int cnt = 0;

            // Load PostgreSQL driver and establish a connection
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "123");

            // Query to fetch all records from the "college" table
            String query = "SELECT * FROM college";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsm = rs.getMetaData();

            cnt = rsm.getColumnCount();
            Object[][] data = new Object[cnt][4];

            String[] columns = new String[]{"College Id", "College Name", "College Address", "Establishment Year"};

            for (int i = 0; i < cnt && rs.next(); i++) {
                data[i] = new Object[4];
                data[i][0] = rs.getInt(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getInt(4);
            }

            // Create a JTable with fetched data
            JTable table = new JTable(data, columns);

            // Add the table to the JFrame
            this.add(new JScrollPane(table));

        } catch (Exception e) {
            System.out.println(e);
        }

        this.setTitle("College Details Table");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Slip27_1();
    }
}


/* vim Slip27_1.java
sudo /opt/tomcat/bin/shutdown.sh
sudo /opt/tomcat/bin/startup.sh

 sudo -u postgres psql

postgres=# \c testdb
You are now connected to database "testdb" as user "postgres".
testdb=# CREATE TABLE college (
    CID SERIAL PRIMARY KEY,
    CName VARCHAR(100) NOT NULL,
    Address VARCHAR(255) NOT NULL,
    Year INT NOT NULL
);
CREATE TABLE
testdb=# INSERT INTO college (CName, Address, Year) VALUES
('MIT College', 'Pune, India', 2001),
('Harvard University', 'Cambridge, USA', 1636),
('Oxford University', 'Oxford, UK', 1096);
INSERT 0 3
testdb=# SELECT * FROM college;
 cid |       cname        |    address     | year 
-----+--------------------+----------------+------
   1 | MIT College        | Pune, India    | 2001
   2 | Harvard University | Cambridge, USA | 1636
   3 | Oxford University  | Oxford, UK     | 1096
(3 rows)


javac -cp ".:postgresql-42.7.5.jar" Slip27_1.java
java -cp ".:postgresql-42.7.5.jar" Slip27_1

*/
