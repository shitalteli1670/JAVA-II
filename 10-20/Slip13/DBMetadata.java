 //Write a Java program to display information about the database and list all the tables in the database. (Use DatabaseMetaData). [15 M] 

import java.sql.*;
import java.io.*;
class DBMetadata
{
    public static void main(String arg[])
    {
        try
        {
            Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "123");
            DatabaseMetaData md = con.getMetaData();
            System.out.println("  DatabaseMetaData Information");
            System.out.println("  ============================");
            System.out.println("  - Product Name          : "+md.getDatabaseProductName());
            System.out.println("  - Driver version Name            : "+md.getDriverVersion());
            System.out.println("  - Product Version Number : "+md.getDatabaseProductVersion());
            //System.out.println("  - Database Major Version : "+md.getDatabaseMajorVersion());
            System.out.println("  - Driver Name            : "+md.getDriverName());
            System.out.println("  - Username               : "+md.getUserName());
            System.out.println("  - Driver Minor Version   : " + md.getDriverMinorVersion());
            ResultSet resultSet = md.getColumns(null, null, "student", null);
            while (resultSet.next()) 
            {
                String name = resultSet.getString("COLUMN_NAME");
                String type = resultSet.getString("TYPE_NAME");
                int size = resultSet.getInt("COLUMN_SIZE");
                System.out.println("Column name: [" + name + "]; type: [" + type+ "]; size: [" + size + "]");
            }
            ResultSet resultset1 =md.getTables(null,null,null,new String[]{"TABLE"});
            while(resultset1.next())
            {
                String tname=resultset1.getString("TABLE_NAME");
                System.out.println(" Table "+tname);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error : "+e);
        }
    }
}

