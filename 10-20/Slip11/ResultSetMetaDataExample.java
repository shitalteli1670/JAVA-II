import java.sql.*;
public class ResultSetMetaDataExample
{
    public static void main(java.lang.String[] args) 
    {
        try 
        {
            Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "123");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM DONAR");
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            int rowCount = 0;
       	    for (int i = 1; i <= colCount; i++)
	        {
                System.out.println("Information about column " + i);
                System.out.println("   Name..........: " + rsmd.getColumnName(i));
                System.out.println("   Data Type.....: " + rsmd.getColumnType(i) + 
                                   " ( " + rsmd.getColumnTypeName(i) + " )");
                System.out.print  ("   Allows Nulls..: ");
                if (rsmd.isNullable(i)==0) 
                    System.out.println("false");
                else
                    System.out.println("true");
            }
        } catch (Exception e) 
        {
            System.out.println("Oops... we have an error... ");
            e.printStackTrace();
        } 
    }
}