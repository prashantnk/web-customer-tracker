package com.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServelet
 */
@WebServlet("/TestDBServelet")
public class TestDBServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		setup connection variables

		String user = "springstudent";
		String pass = "springstudent";
		String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker";
		String driver = "com.mysql.cj.jdbc.Driver";

//		get connection

		try {

			PrintWriter out = response.getWriter();

			out.println("Connecting to db ... ");

			Class.forName(driver);

			Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);

			out.println("Connection Succesful !");

			myConn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
