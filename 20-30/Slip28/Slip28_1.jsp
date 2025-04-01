<h2>Reverse String</h2>
    <form method="post">
        Enter a String: <input type="text" name="str">
        <input type="submit" value="Reverse">
    </form>
    <%
    if (request.getMethod().equals("POST")) {
        String st = request.getParameter("str");
        StringBuffer sb=new StringBuffer(st);
	sb=sb.reverse();
    %>
    <p>
        The Reverse String is <%= sb %> 
    </p>
    <% } %>

/*  cd /opt/tomcat/bin
./shutdown.sh
./startup.sh
http://localhost:8080/Slip28_1.jsp
*/