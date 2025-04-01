import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Slip10_2 extends JFrame implements ActionListener
{
     JLabel l1,l2,l3;
     JTextField t1,t2,t3;
     JButton btn;
     Connection con=null;
     ResultSet rs=null;
     Slip10_2()
     {
           l1= new  JLabel("Roll No:");
           l2= new  JLabel("Student Name:");
           l3= new  JLabel("Percentage:");
           t1= new  JTextField();
           t2= new  JTextField();
           t3= new  JTextField();
           btn = new JButton("Show");
	          setLayout(new FlowLayout());
           setTitle("Employee Information");
           setSize(250,200);
		        Panel p1=new Panel();
           	p1.setLayout(new GridLayout(3,2,20,20));
           	p1.add(l1);p1.add(t1);
	   	      p1.add(l2);p1.add(t2);
		        p1.add(l3);p1.add(t3);
		        add(p1);
	          add(btn);
           try
           {
		        Class.forName("org.postgresql.Driver");
	          con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "123");
	        }catch(Exception e)	
		{    
         	System.out.println(e);
                }
	   btn.addActionListener(this);
	   setVisible(true);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
	try{
	Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
ResultSet.CONCUR_UPDATABLE);  
	ResultSet rs = st.executeQuery("SELECT * FROM student");
	rs.first();
 	t1.setText(""+rs.getInt(1));
	t2.setText(""+rs.getString(2));
	t3.setText(""+rs.getInt(3));	
        }catch(Exception e){}
	}
	public static void main(String arg[])
	{
	new Slip10_2();
	}
}

