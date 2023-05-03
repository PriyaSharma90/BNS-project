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

/**
 * Servlet implementation class GridUpdate
 */
@WebServlet("/GridUpdate")
public class GridUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GridUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		EmpDao dao = new EmpDao();
		PrintWriter out = response.getWriter();
		HttpSession httpSession = request.getSession();

		Connection con = (Connection) httpSession.getAttribute("connection");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		/* System.out.println("con is :"+con); */
		
		Emp e = dao.getEmployeeById(id,con);
		
		/*
		 * if(e != null) System.out.println("employee object is :"+e);
		 */
		
		String name = request.getParameter("name");
		String epassword = request.getParameter("epassword");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		
		System.out.println("employee name is :"+name);
		System.out.println("employee epassword is :"+epassword);
		System.out.println("employee email is :"+email);
		System.out.println("employee countr is :"+country);
		
		e.setId(id);
		e.setName(name);
		e.setEpassword(epassword);
		e.setEmail(email);
		e.setCountry(country);

		int status = dao.update(e,con);
		if (status > 0) {
			/* response.sendRedirect("ViewEmpServlet?page=1"); */
		} else {
			out.println("Sorry! unable to update record");
		}
		
	
	}

}
