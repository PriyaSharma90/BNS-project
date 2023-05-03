package com.parth.EmpBean;

import java.io.Serializable;

public class Emp implements Serializable {

	/**
	 * @author coretest1
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name, epassword, email, country, uname, upassword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEpassword() {
		return epassword;
	}

	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}


	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", epassword=" + epassword + ", email=" + email + ", country="
				+ country + ", uname=" + uname + ", upassword=" + upassword + "]";
	}
	
}
