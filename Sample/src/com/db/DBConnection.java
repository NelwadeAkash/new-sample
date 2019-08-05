package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
		
		public static Connection getConnection() throws SQLException {
			
			Connection connection = null;
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection
						("jdbc:mysql://localhost:3306/organisation","root","root");
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
			return connection;
			
		}
		
		public static void close(Connection cn , PreparedStatement stmt , ResultSet rs) {
			
			
				try {
					
					if(cn != null) {
						cn.close();
					}
					
					if(stmt != null) {
						stmt.close();
					}
					
					if(rs != null) {
						rs.close();
					}
					
				} catch (SQLException e) {
					
				}
			
		}
			
}
