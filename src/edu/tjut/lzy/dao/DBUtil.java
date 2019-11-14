package edu.tjut.lzy.dao;

import java.sql.*;

public class DBUtil {
	
	public static Connection getConn(){
		String url="jdbc:sqlserver://127.0.0.1:1433;databasename=Æû³µ×âÁÞÏµÍ³";
		String user="sa";
		String password="1";
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static ResultSet execQuery(String sql){
		Connection connection = getConn();
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		try {
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rSet;
	}
	
	public static int execUpdate(String sql) {
		Connection connection = getConn();
		PreparedStatement pStatement = null;
		int r=0;
		try {
			connection = getConn();
			pStatement = connection.prepareStatement(sql);
			r = pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}
	
	
//	public static void main(String[] args) {
//		ResultSet rSet = execQuery("select * from lease");
//		String carid;
//		Date startdate;
//		String method;
//		String state;
//		
//		try {
//			//execUpdate("insert into [User](username,password)values('005','111111')");
//			while (rSet.next()) {
//				carid = rSet.getString("carid");
//				startdate = rSet.getDate("startdate");
//				method = rSet.getString("method");
//				state = rSet.getString("state");
//				System.out.println(carid+","+startdate+","+method+","+state);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
