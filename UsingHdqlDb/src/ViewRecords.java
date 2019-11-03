import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewRecords extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try {
            ServletContext context=getServletContext();
            con=(Connection)context.getAttribute("con");
            PreparedStatement pst=con.prepareStatement("select * from contacts");
            pst.clearParameters();
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                out.write("<br/>"+rs.getString(1));
                out.write(", "+rs.getString(2));
                out.write(", "+rs.getString(3));
            }
            out.write("<hr/><a href='index.html'>Home</a> ");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}