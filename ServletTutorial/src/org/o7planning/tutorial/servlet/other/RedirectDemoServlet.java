package org.o7planning.tutorial.servlet.other;
 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.tutorial.beans.Constants;
 
@WebServlet("/other/redirectDemo")
public class RedirectDemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    // Request:
    // http://localhost:8080/ServletTutorial/other/forwardDemo?redirect=true
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Get value of parameter on URL.
        String redirect = request.getParameter("redirect");
 
        if ("true".equals(redirect)) {
            System.out.println("Redirect to ShowMeServlet");
 
            request.setAttribute(Constants.ATTRIBUTE_USER_NAME_KEY, 
                    "Hi, I'm Ralph looking at you. Here from Redirect!");

            String contextPath = request.getContextPath();
            
            response.sendRedirect(contextPath + "/other/showMe");
 
            return;
        }
        ServletOutputStream out = response.getOutputStream();
        out.println("<h1>Text of RedirectDemoServlet</h1>");
        out.println("- servletPath= " + request.getServletPath());
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
 
}