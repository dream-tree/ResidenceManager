package com.marcin.residence.testdb;

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
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet { 
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user = "home_user";
		String pass = "***";
		String jdbcUrl = "jdbc:mysql://localhost:3306/residence_tracker?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		String driver = "com.mysql.cj.jdbc.Driver";   
	
		try {
			PrintWriter out = response.getWriter();
			out.println("Conecting to the database: " + jdbcUrl);
			Class.forName(driver);       
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);   
			out.print("Connection successful");
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);		
		}
	} 
}
