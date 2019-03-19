package com.guigu.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ggssm?characterEncoding=utf-8","root","");
			System.out.println("链接成功");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn){
		try {
			if(rs!=null){
			rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
	}
	}
}
