package org.o7planning.tutorial.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = { "/annotationExample", "/annExample" }, initParams = {
        @WebInitParam(name = "emailSupport1", value = "abc@example.com"),
        @WebInitParam(name = "emailSupport2", value = "tom@example.com") })
public class AnnotationExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String emailSupport1;
	
	public AnnotationExampleServlet() {
		
	}
	// This method is always called once after the Servlet object is created.
	@Override
	public void init(ServletConfig config) throws ServletException  {
		super.init(config);
        // Get the value of the initialization parameter of the Servlet.
        // (According to the Configuration of this Servlet in web.xml).
		this.emailSupport1 = config.getInitParameter("emailSupport1");
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        // Get the initialization parameter's value in a different way.
        String emailSupport2 = this.getServletConfig().getInitParameter("emailSupport2");
 
        ServletOutputStream out = response.getOutputStream();
 
        out.println("<html>");
        out.println("<head><title>Init Param</title></head>");
 
        out.println("<body>");
        out.println("<h3>Init Param mit annotations</h3>");
        out.println("<p>emailSupport1 = " + this.emailSupport1 + "</p>");
        out.println("<p>emailSupport2 = " + emailSupport2 + "</p>");
        out.println("</body>");
        out.println("<html>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
	

}
