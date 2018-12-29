package org.o7planning.tutorial.servlet.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.tutorial.beans.UserInfo;
import org.o7planning.tutorial.beans.Constants;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletOutputStream out = response.getOutputStream();
		// get Session
		HttpSession session = request.getSession();
		// LoginScreen schon gelaufen
		UserInfo loginInfo = new UserInfo("Tom", "BRD", 5);
		//speichern in der Session 
		session.setAttribute(Constants.SESSION_USER_KEY, loginInfo);
		// Ausgabe
		out.println("<html>");
        out.println("<head><title>Session example</title></head>");
 
        out.println("<body>");
        out.println("<h3>You are now really logined!, info stored in session</h3>");
 
        out.println("<a href='userInfo'>View User Info</a>");
        out.println("</body>");
        out.println("<html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
