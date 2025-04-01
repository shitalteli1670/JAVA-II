import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class Slip2_2 extends HttpServlet
 {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
      try
       {  
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<title>Request Information Example</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Request Information Example</h3>");
        java.util.Properties p=System.getProperties();
 	String serverOs = System.getProperty("os.name");
        out.println("Server Name :"+request.getServerName()+"<br>");        
        out.println("Operating System Name :"+serverOs+"<br>"); 
        out.println("Method: " + request.getMethod()+"<Br>");
        out.println("Request URI: " + request.getRequestURI()+"<Br>");
        out.println("Protocol: " + request.getProtocol()+"<Br>");
        out.println("PathInfo: " +request.getServletPath()+"<Br>");
        out.println("Remote Address: " +request.getRemoteAddr()+"<Br>");
        out.println("</body>");
        out.println("</html>");
       }
       catch(Exception e)
       {
         e.printStackTrace();
       }
    }
 }