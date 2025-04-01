import javax.swing.*;
import java.sql.*;

public class TableExample extends JFrame {
    public TableExample() {
        try {
            int cnt = 0;

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "123");
            
            String query = "SELECT * FROM project";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsm = rs.getMetaData();
            cnt = rsm.getColumnCount();
            
            Object[][] data = new Object[cnt][4];
            String[] columns = {"Project Id", "Project Name", "Project Description", "Project Status"};
            
            for (int i = 0; i < cnt && rs.next(); i++) {
                data[i] = new Object[4];
                data[i][0] = rs.getInt(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getString(4);
            }
            
            // Create table with data
            JTable table = new JTable(data, columns);
            
            // Add the table to the frame
            this.add(new JScrollPane(table));
        } catch (Exception e) {
            System.out.println(e);
        }
        
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TableExample();
    }
}
