package com.parth.EmpServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parth.EmpBean.Emp;
import com.parth.EmpDao.EmpDao;

@WebServlet("/ViewEmpServlet")
public class ViewEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
		EmpDao dao = new EmpDao();
		HttpSession httpSession = request.getSession();

		Connection con = (Connection) httpSession.getAttribute("connection");

		PrintWriter out = response.getWriter();
		/*
		 * String spageid = request.getParameter("page"); int pageid =
		 * Integer.parseInt(spageid); int total = 25; if (pageid == 1) { } else { pageid
		 * = pageid - 1; pageid = pageid * total + 1; }
		 */
		
		List< Emp> list = dao.getAllEmployees(con);
			out.println("<a href='index.jsp'>Add Employee</a>");

			out.print("<h1> EMP LIST  </h1>");
			out.print("<table border='1' cellpadding='4' width='60%'>");
			out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Country</th><th>Update</th><th>Delete</th>");
			for (Emp e : list) {
				out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td>" + "<td>" + e.getEmail() + "</td><td>"
						+ e.getCountry() + "</td><td><a href='UpdateEmpServlet?id=" + e.getId() + "'>"
						+ "Edit</a></td><td><a href='DeleteEmpServlet?id=" + e.getId() + "'>Delete</a></td></tr>");
			}
			out.print("</table>");

			out.close();
		}
		
		/*List<Emp> list = dao.getRecords(pageid, total,con);
		out.println("<a href='index.jsp'>Add Employee</a>");

		out.print("<h1> EMP LIST Page No: " + spageid + "</h1>");
		out.print("<table border='1' cellpadding='4' width='60%'>");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Country</th><th>Update</th><th>Delete</th>");
		for (Emp e : list) {
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td>" + "<td>" + e.getEmail() + "</td><td>"
					+ e.getCountry() + "</td><td><a href='UpdateEmpServlet?id=" + e.getId() + "'>"
					+ "Edit</a></td><td><a href='DeleteEmpServlet?id=" + e.getId() + "'>Delete</a></td></tr>");
		}
		out.print("</table>");

		out.print("<a href='ViewEmpServlet?page=1'>1</a> ");
		out.print("<a href='ViewEmpServlet?page=2'>2</a> ");
		out.print("<a href='ViewEmpServlet?page=3'>3</a> ");

		out.close();*/

	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
