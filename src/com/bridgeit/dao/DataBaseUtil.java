package com.bridgeit.dao;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataBaseUtil {
	
	static DataBaseUtil dDataBaseUtil = new DataBaseUtil();

	
	public static DataBaseUtil getDataBaseUtil()
	{
		return dDataBaseUtil;
	}

private ComboPooledDataSource dataSource;
	
	private  void initConnection()
	{
		if(dataSource == null)
		{
			dataSource = new ComboPooledDataSource();
			Properties pr = new Properties();
			try{
				InputStream in = this.getClass().getResourceAsStream("message.properties");
				pr.load(in);
				System.out.println(pr.getProperty("driverClass"));
				System.out.println(pr.getProperty("dbUser"));
				System.out.println(pr.getProperty("dbUrl"));
				dataSource.setDriverClass(pr.getProperty("driverClass"));
				dataSource.setJdbcUrl(pr.getProperty("dbUrl"));
				dataSource.setUser(pr.getProperty("dbUser"));
				dataSource.setPassword(pr.getProperty("dbPassword"));
				dataSource.setMaxPoolSize(10);
				dataSource.setMinPoolSize(5);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public  Connection getDBConnection() throws SQLException{
		System.out.println(" it is in the db connection");
		initConnection();
		return dataSource.getConnection();
	}
	public  void closeConnection()
	{
		if(dataSource!=null)
			try {
				dataSource.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	}
}
