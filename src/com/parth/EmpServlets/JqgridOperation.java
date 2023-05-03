package com.parth.EmpServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parth.EmpBean.Emp;
import com.parth.EmpDao.EmpDao;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class JqgridOperation
 */
@WebServlet("/JqgridOperation")
public class JqgridOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JqgridOperation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside do get");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		/*
		 * String status = request.getParameter("status");
		 * 
		 * String rows = request.getParameter("rows"); String page =
		 * request.getParameter("page");
		 * 
		 * int totalPages = 0; int totalCount = 15;
		 * 
		 * if (totalCount > 0) { if (totalCount % Integer.parseInt(rows) == 0) {
		 * totalPages = totalCount / Integer.parseInt(rows); } else { totalPages =
		 * (totalCount / Integer.parseInt(rows)) + 1; }
		 * 
		 * } else { totalPages = 0; }
		 */
		
		/*
		 * String page = request.getParameter("page"); String limit =
		 * request.getParameter("rows"); String sidx = request.getParameter("sidx");
		 * String sord = request.getParameter("sord");
		 * 
		 * if (sidx == "0") { sidx = "1"; }
		 */
		EmpDao dao = new EmpDao();
		HttpSession httpSession = request.getSession();
		Connection con = (Connection) httpSession.getAttribute("connection");
		PrintWriter out = response.getWriter();

		List<Emp> list = new ArrayList<Emp>();
		list = dao.getAllEmployees(con);
		
		if(list != null ) {
			System.out.println("Yah notnull");
			list.forEach(data->{
				System.out.println("List item is : "+data.toString());
			});
			
		}
		
		JSONObject mainObj = new JSONObject();
		mainObj.put("page", 1);
		mainObj.put("total", 1);
		mainObj.put("records", 1);
		mainObj.put("rows", list);
		out.print(mainObj.toString());
		
		/*
		 * jsonObject.put("rows", list); out.print(jsonObject.toString());
		 */		
		/*
		 * Gson gson = new Gson(); JsonElement element = gson.toJsonTree(list, new
		 * TypeToken<List<Emp>>() { }.getType());
		 * 
		 * JsonArray jsonArray = element.getAsJsonArray();
		 * response.setContentType("application/json"); out.print(jsonArray.toString());
		 * 
		 * System.out.println(jsonArray);	
		 */
		
		/*
		 * JSONArray array = (JSONArray)JSONSerializer.toJSON(list); String json =
		 * "{'page' :1 ,'total': '2' , 'records': '1','rows': "+array+"}"; JSONObject
		 * jsonObject = (JSONObject)JSONSerializer.toJSON(json);
		 * out.print(jsonObject.toString());
		 * 
		 * System.out.println(array); System.out.println(jsonObject);
		 */
		
		
		

		
		/* List< Emp> list = dao.getAllEmployees(con); */

//		JSONArray jsonArray = (JSONArray)JSONSerializer.toJSON(list);
//		String json = "{'page':1,'total':'2','records':'1','rows':"+jsonArray+"}";
//		JSONObject jsonObject = (JSONObject)JSONSerializer.toJSON(json);
//		
//		out.print(jsonObject.toString());
	}

}
