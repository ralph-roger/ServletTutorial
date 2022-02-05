package org.o7planning.tutorial.servlet.other;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.tutorial.beans.Constants;

@WebServlet("/other/showMe")
public class ShowMeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get value of an attribute of the request.
		String value = (String) request.getAttribute(Constants.ATTRIBUTE_USER_NAME_KEY);

		ServletOutputStream out = response.getOutputStream();

		out.println("<h1>ShowMeServlet</h1>");
		out.println("<p></p>");
		if (value == null) {
			out.println("Constante ATTRIBUT_USER_NAME_KEY nicht gesetzt (null), da per redirect oder direkt gerufen. Neue URL");
		} else {
			out.println("Wert der Constanten ATTRIBUT_USER_NAME_KEY = " + value + " URL nicht verädert");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}