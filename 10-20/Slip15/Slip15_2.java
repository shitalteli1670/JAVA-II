import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Slip15 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        PrintWriter pw = null;
        try {
            res.setContentType("text/html");
            pw = res.getWriter();

            Cookie[] cookies = req.getCookies();
            boolean isNewUser = true;

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("Count")) {
                        int visitCount = Integer.parseInt(cookie.getValue()) + 1;
                        pw.println("Page is visited for " + visitCount + " times.");
                        Cookie newCookie = new Cookie("Count", Integer.toString(visitCount));
                        res.addCookie(newCookie);
                        isNewUser = false;
                        break;
                    }
                }
            }
            
            if (isNewUser) {
                pw.println("<b>Welcome</b>");
                Cookie newCookie = new Cookie("Count", "1");
                res.addCookie(newCookie);
            }
        } catch (Exception e) {
            pw.println("Error: " + e);
        }
    }
}
