package com.masai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbUtils {

	
	public static Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResourceBundle rb = ResourceBundle.getBundle("dbDeatils");
		return DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("pass"));
	}
	
	
	public static void closeConn(Connection conn) throws SQLException {
		if(conn!=null) conn.close();
	}
	
	
	public static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst() && rs.getRow() == 0)?true:false;
	}
}
