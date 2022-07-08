package com.xworkz.coreSpring;

public class DBConnection {
	String username;
	String password;
	String url;

	public DBConnection(String username, String password, String url) {

		this.username = username;
		this.password = password;
		this.url = url;
		System.out.println("DBConnection [username=" + username + ", password=" + password + ", url=" + url + "]");
	}

}
