package com.parth.EmpDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.parth.ConnectionFactory.ConnectionFactory;
import com.parth.EmpBean.Emp;
import com.parth.EmpServlets.LoginServlet;



public class EmpDao {
		

	public  int AddEmp(Emp e,Connection connection) {
		int status = 0;
		try {
		
			
			PreparedStatement ps = connection
					.prepareStatement("insert into emp_managment(full_name,epassword,email,country) values (?,?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEpassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());

			status = ps.executeUpdate();

			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public  int update(Emp e,Connection connection) {
		int status = 0;
		try {
			
			PreparedStatement ps = connection
					.prepareStatement("update emp_managment set full_name=?,epassword=?,email=?,country=? where id=?");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEpassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			ps.setInt(5, e.getId());

			status = ps.executeUpdate();

			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public  int delete(int id, Connection connection) {
		int status = 0;
		try {
			
			PreparedStatement ps = connection.prepareStatement("delete from emp_managment where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public  Emp getEmployeeById(int id,Connection connection) {
		Emp e = new Emp();

		try {
		
			PreparedStatement ps = connection.prepareStatement("select * from emp_managment where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEpassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public  List<Emp> getAllEmployees(Connection connection) {
		List<Emp> list = new ArrayList<Emp>();

		try {
			
			PreparedStatement ps = connection.prepareStatement("select * from emp_managment");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEpassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				list.add(e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/*
	 * public List<Emp> getRecords(int start, int total,Connection connection) {
	 * List<Emp> list = new ArrayList<Emp>(); try {
	 * 
	 * PreparedStatement ps = connection
	 * .prepareStatement("select * from emp_managment limit " + (start - 1) + "," +
	 * total); ResultSet rs = ps.executeQuery(); while (rs.next()) { Emp e = new
	 * Emp(); e.setId(rs.getInt(1)); e.setName(rs.getString(2));
	 * e.setEmail(rs.getString(4)); e.setCountry(rs.getString(5)); list.add(e); }
	 * 
	 * } catch (Exception e) { System.out.println(e); } return list; }
	 */
}
