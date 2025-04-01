import java.sql.*;
import java.util.*;
public class Slip7_2
{
    public static void main(String[] args) 
    {
        Scanner s =new Scanner(System.in);
	    try
	    {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "123");
            System.out.println("Enter how many records you want to insert");
            int n=s.nextInt();
            for(int i=0;i<n;i++)
	        {
                System.out.println("Enter the product "+(i+1)+"details");
                System.out.println("Enter Product id");
                int pno=s.nextInt();
                System.out.println("Enter Product Name");
                String name=s.next();
	            System.out.println("Enter Product Price");
                int pr=s.nextInt();
                PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?)");
                ps.setInt(1,pno);
                ps.setString(2,name);
                ps.setInt(3,pr);
                ps.executeUpdate();
            }
            Statement t=con.createStatement();
            ResultSet rs=t.executeQuery("select * from product");	
	        System.out.println("Product Number	Product Name 	Product Price ");
		    while(rs.next())
       	    System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));          
	    }
        catch(Exception e){System.out.println(e);}
    }
}


