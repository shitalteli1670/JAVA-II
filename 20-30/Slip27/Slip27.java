import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Slip27 extends HttpServlet {   

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        int newTimeout = 3600; // Set session timeout to 1 hour

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(newTimeout);

        response.setContentType("text/html");
        response.getWriter().println("Session inactive timeout has been changed to " + newTimeout + " seconds.");
    }
}
