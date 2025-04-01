import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Slip1_2_JDBC extends JFrame implements ActionListener
{
     JLabel l1,l2,l3,l4;
     JTextField t1,t2,t3,t4;
     JButton btnAdd;
     Connection con=null;
     ResultSet rs=null;
     Slip1_2_JDBC()
     {
           l1= new  JLabel("Employee no:");
           l2= new  JLabel("Employee Name:");
           l3= new  JLabel("Employee Designation:");
           l4= new  JLabel("Employee Salary:");
           t1= new  JTextField();
           t2= new  JTextField();
           t3= new  JTextField();
           t4= new  JTextField();
           btnAdd = new JButton("Add");
	setLayout(new FlowLayout());
           setTitle("Employee Registration");
           setSize(350,250);
		Panel p1=new Panel();
           	p1.setLayout(new GridLayout(4,2,20,20));
           	p1.add(l1);p1.add(t1);
	   	p1.add(l2);p1.add(t2);
		p1.add(l3);p1.add(t3);
		p1.add(l4);p1.add(t4);
	   add(p1);
	   add(btnAdd);
           try{
		Class.forName("org.postgresql.Driver");
	        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "root");
	      }
		catch(Exception e)	
		{    
         	System.out.println(e);
                }
	   btnAdd.addActionListener(this);
	   setVisible(true);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
	int no=Integer.parseInt(t1.getText());	
	String name=t2.getText();
	String desg=t3.getText();
	int sal=Integer.parseInt(t4.getText());	
	try{
		PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
		ps.setInt(1,no);
		ps.setString(2,name);
		ps.setString(3,desg);
		ps.setInt(4,sal);
		int i=ps.executeUpdate();
           	JOptionPane.showMessageDialog(null,"Record Inserted Succfully");
            }catch(Exception e){}
	}
	public static void main(String arg[])
	{
	new Slip1_2_JDBC();
	}
}

/*
sudo -u postgres psql
CREATE DATABASE testdb;
\c testdb

CREATE TABLE employee (
    emp_no INT PRIMARY KEY,
    emp_name VARCHAR(50),
    emp_designation VARCHAR(50),
    emp_salary INT
);

javac -cp .:postgresql-42.7.5.jar Slip1_2_JDBC.java
java -cp .:postgresql-42.7.5.jar Slip1_2_JDBC

*/