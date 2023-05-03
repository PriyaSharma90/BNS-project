package com.parth.EmpServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parth.EmpBean.Emp;
import com.parth.EmpDao.EmpDao;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("epassword");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		HttpSession httpSession = request.getSession();
		
		Connection con = (Connection) httpSession.getAttribute("connection");
		Emp e = new Emp();
		EmpDao dao = new EmpDao();
		
		e.setName(name);
		e.setEpassword(password);
		e.setEmail(email);
		e.setCountry(country);

		int status =dao.AddEmp(e,con);
		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
		//	request.getRequestDispatcher("index.jsp").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();

	}
	
	

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
