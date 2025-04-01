2. Write a SERVLET application to accept username and password, search them into database, if found then display appropriate message on the browser otherwise display error message. [15 M]

//Login.html

    <form method='post' action='http://localhost:8080/examples/Login'>

    Name:<input type="text" name="username"/><br/><br/>  

    Password:<input type="password" name="userpass"/><br/><br/>  

    <input type="submit" value="login"/>  

    </form>  

//Login.java

import java.io.*;

import javax.servlet.*;

import javax.servlet.http.*;

import java.sql.*;


public class Login extends HttpServlet 

{

 

 public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException 

  {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        

        String email = request.getParameter("username");

        String pass = request.getParameter("userpass");

      try{

	    Class.forName("org.postgresql.Driver");

	

         Connection c = DriverManager.getConnection("jdbc:postgresql

         ://localhost:5432/testdb","postgres", "123");

         PreparedStatement ps =c.prepareStatement

                             ("select * from login where uname=? and pass=?");

         ps.setString(1, email);

         ps.setString(2, pass);

         ResultSet rs =ps.executeQuery();

         if(rs.next()) 

        {

            out.println("Welcome");

        }

        else

        {

           out.println("Username or Password incorrect");

           response.sendRedirect("login.html");

        }

         

      }catch(Exception e)

      {

          e.printStackTrace();

      }

    }  

}

