package com.bridgeit.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCHelper {

	public void close(ResultSet rs)
		{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
		public void close(PreparedStatement stm)
		{
			if(stm!=null)
				try {
					stm.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
		public void close(Connection con)
		{
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
	
}
