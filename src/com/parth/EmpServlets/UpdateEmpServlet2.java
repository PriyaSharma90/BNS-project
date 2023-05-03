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

@WebServlet("/UpdateEmpServlet2")
public class UpdateEmpServlet2 extends HttpServlet {
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
		HttpSession httpSession = request.getSession();

		Connection con = (Connection) httpSession.getAttribute("connection");

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("name");
		String epassword = request.getParameter("epassword");
		String email = request.getParameter("email");
		String country = request.getParameter("country");

		Emp e = new Emp();
		EmpDao dao = new EmpDao();
		e.setId(id);
		e.setName(name);
		e.setEpassword(epassword);
		e.setEmail(email);
		e.setCountry(country);

		int status = dao.update(e,con);
		if (status > 0) {
			response.sendRedirect("ViewEmpServlet?page=1");
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();

	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
