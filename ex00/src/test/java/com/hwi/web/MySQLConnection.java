package com.hwi.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnection {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL    = "jdbc:mysql://hwi.mismaven.kr/hwi";
	private static final String USER   = "hwi";
	private static final String PW     = "hwi0817!";
	
	@Test
	public void connection() throws Exception {
		Class.forName(DRIVER);
		
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			System.out.println(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
