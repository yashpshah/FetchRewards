package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserUtil {
	public static Connection createConnection(){
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			
		}
	return connection;
	}

}
