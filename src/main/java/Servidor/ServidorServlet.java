package Servidor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import Servidor.User;

public class ServidorServlet extends HttpServlet {
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}

	private DataSource ds;
	String passdb;

	public ServidorServlet() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/gestion");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null) {
			System.out.println("Sesion nula");
			res.sendRedirect("http://localhost:8080/error.html");
		}
		Vector buylist = (Vector) session.getValue("Servidor.shoppingcart");
		String action = req.getParameter("action");
		if (action.equals("LOGIN")) {
			String name = req.getParameter("username");
			String pass = req.getParameter("password");
			System.out.println(pass + " 1");
			Connection con = null;
			try {
				con = ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// Hacemos la connexión

			// Preparamos la query
			Statement stmt = null;
			try {
				stmt = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// creamos para poder hacer una query

			String query = "select password from users where username = '"
					+ name + "';";// Construimos la query
			ResultSet rs = null;
			try {
				rs = stmt.executeQuery(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// Enviamos la query
			try {
				rs.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				passdb = rs.getString("password");
				System.out.println(passdb + " 1");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (passdb.equals(pass)) {
				String url = "/NewMessage.jsp";
				req.setAttribute("username", name);
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher(url);
				rd.forward(req, res);
			} else
				res.sendRedirect("http://localhost:8080/ExamenRoc/LogginInvalid.jsp");
		}
		if (action.equals("SEND")) {
			String subject = req.getParameter("subject");
			String pass = req.getParameter("password");
			

		}

	}

}