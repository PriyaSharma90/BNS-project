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

@WebServlet("/UpdateEmpServlet")
public class UpdateEmpServlet extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Employee</h1>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		HttpSession httpSession = request.getSession();

		Connection con = (Connection) httpSession.getAttribute("connection");

		Emp e = dao.getEmployeeById(id,con);

		out.print("<form action='UpdateEmpServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + e.getName() + "'/></td></tr>");
		out.print("<tr><td>Password:</td><td><input type=' password' name='epassword' value='" + e.getEpassword()
				+ "'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='" + e.getEmail() + "'/></td></tr>");
		out.print("<tr><td>Country:</td><td>");
		out.print("<select name='country' style='width:150px'>");
		out.print("<option>India</option>");
		out.print("<option>USA</option>");
		out.print("<option>UK</option>");
		out.print("<option>Other</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Update'/></td></tr>");
		out.print("</table>");
		out.print("</form>");

		out.close();

	}

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
