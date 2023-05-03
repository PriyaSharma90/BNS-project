package com.parth.EmpServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parth.ConnectionFactory.ConnectionFactory;
import com.parth.EmpBean.Emp;
import com.parth.EmpDao.EmpDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html/jsp");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("uname");
		String pass = request.getParameter("upassword");
		System.out.println(name);
		System.out.println(pass);
		/*
		 * HttpSession session = request.getSession(); session.setAttribute("uname",
		 * name); session.setAttribute("upassword",pass);
		 */
		HttpSession httpSession = request.getSession(false);
		
		Connection connection;
		try {
			connection= ConnectionFactory.getInstance().getConnection(name, pass);
			httpSession.setAttribute("connection", connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		 * Connection getConnection( ) { HttpSession session1 = request.getSession();
		 * session1.setAttribute("uname", name);
		 * session1.setAttribute("upassword",pass); Connection connection = null;
		 * Class.forName("com.mysql.jdbc.Driver"); connection =
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/demo",uname,
		 * upassword); }
		 */
		/*
		 * LoginServlet s = new LoginServlet(); RequestDispatcher rs
		 * =request.getRequestDispatcher("ConnectionFactory"); rs.forward(request,
		 * response);
		 */
		
		
		/*
		 * request.setAttribute("dbUser", name); request.setAttribute("dbPwd", pass);
		 */
		RequestDispatcher rd = request.getRequestDispatcher("jqgridoperation.jsp");
		rd.forward(request, response);

		out.close();
	}
}
