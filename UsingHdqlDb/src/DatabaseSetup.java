import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hsqldb.server.Server;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DatabaseSetup extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;
	Server server;

	public void init() throws ServletException {
		server = new Server();
		server.setAddress("localhost");
		server.setDatabaseName(0, "mydb1");
		server.setDatabasePath(0, "file:C:/Users/ralph/Entwicklung/Datenbank/hsqldb_databases/db");
		server.setPort(1234);
		server.setTrace(true);
		server.setLogWriter(new PrintWriter(System.out));
		server.start();
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(System.out);
		}
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1234/mydb1", "SA", "");
			DatabaseMetaData dbm = con.getMetaData();
			ResultSet rs = dbm.getTables(null, null, "contacts", null);
			if (rs.next()) {
				con.createStatement()
						.executeUpdate("create table contacts (name varchar(45),email varchar(45),phone varchar(45))");
			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		ServletContext context = getServletContext();
		context.setAttribute("con", con);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String reqCommand = req.getParameter("command");
		if (reqCommand.equalsIgnoreCase("info")) {
			out.write("<br/>Address : " + server.getAddress());
			out.write("<br/>Database Name : " + server.getDatabaseName(0, true));
			out.write("<br/>DatabasePath : " + server.getDatabasePath(0, true));
			out.write("<br/>Port : " + server.getPort());
			out.write("<br/>DefaultWebPage : " + server.getDefaultWebPage());
			out.write("<br/>ProductName : " + server.getProductName());
			out.write("<br/>ProductVersion : " + server.getProductVersion());
			out.write("<br/>Protocol : " + server.getProtocol());
			out.write("<br/>ServerId : " + server.getServerId());
			out.write("<br/>State : " + server.getState());
			out.write("<br/>StateDescriptor : " + server.getStateDescriptor());
			out.write("<br/>WebRoot : " + server.getWebRoot());
		}
		if (reqCommand.equalsIgnoreCase("stop")) {
			server.setLogWriter(out);
			server.shutdown();
			out.write("Database has been stopped.");
		}
		if (reqCommand.equalsIgnoreCase("start")) {
			server.setLogWriter(out);
			server.start();
			out.write("Database has been started.");
		} else {
			out.write("No command matched");
		}
		out.write("<br/><a href='ViewRecords'>View Records</a>");
		out.write("<br/><a href='index.html'>Home</a> ");
	}
	public void shutDown() {
		server.shutdown();
		System.out.println("Database has been stopped.");

		
	}
}