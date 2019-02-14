import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Helloworld extends HttpServlet {

 public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
  
  PrintWriter out = response.getWriter();
	out.println("<html>"+"<body>"+"<center>"+"<h1>HELLO WORLD</h1>"+"</center>"+"<br>"+"</body>"+"</html>");
	
	//To compile the java code>javac -classpath "D:\lxisoft.app\apache-tomcat-8.5.38\lib\servlet-api.jar" -d classes src\Helloworld.java
 }
}