import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Slip25_2 extends JFrame implements ActionListener {
    JLabel l1;
    JButton create, alter, drop;
    JTextField t1;
    Connection con;

    public Slip25_2() {
        l1 = new JLabel("Type your DDL query here:");
        t1 = new JTextField(30);
        create = new JButton("Create Table");
        alter = new JButton("Alter Table");
        drop = new JButton("Drop Table");

        setLayout(new FlowLayout());
        add(l1);
        add(t1);
        add(create);
        add(alter);
        add(drop);

        create.addActionListener(this);
        alter.addActionListener(this);
        drop.addActionListener(this);

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "123");
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e);
        }

        setTitle("DDL Queries");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(340, 350);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String query = t1.getText();
        try {
            Statement st = con.createStatement();

            if (ae.getSource() == create) {
                st.execute(query);
                System.out.println("Table Created Successfully");
            } else if (ae.getSource() == alter) {
                st.execute(query);
                System.out.println("Table Altered Successfully");
            } else if (ae.getSource() == drop) {
                st.execute(query);
                System.out.println("Table Dropped Successfully");
            }
        } catch (Exception e) {
            System.out.println("SQL Error: " + e);
        }
    }

    public static void main(String[] args) {
        new Slip25_2();
    }
}

/* sudo /opt/tomcat/bin/shutdown.sh
sudo /opt/tomcat/bin/startup.sh
javac -cp ".:postgresql-42.7.5.jar" Slip25_2.java
java -cp ".:postgresql-42.7.5.jar" Slip25_2 101
*/
