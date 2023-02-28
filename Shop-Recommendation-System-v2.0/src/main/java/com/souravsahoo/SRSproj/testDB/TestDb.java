package com.souravsahoo.SRSproj.testDB;

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
 * Servlet implementation class TestDb
 */
@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/shop_recommendation_system?useSSL=false";
		String user = "springstudent";
		String pass = "springstudent";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			
			PrintWriter out = response.getWriter();
			out.println("connecting to: " + url);
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,pass);
			out.println("success");
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
