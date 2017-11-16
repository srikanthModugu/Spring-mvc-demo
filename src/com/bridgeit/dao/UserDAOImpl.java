package com.bridgeit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bridgeit.model.Person;

public class UserDAOImpl implements UserDAO {

	JDBCHelper helper = new JDBCHelper();
	DataBaseUtil db = DataBaseUtil.getDataBaseUtil();
	public Boolean addPerson(Person person) {

		Connection conn = null;
		PreparedStatement stm = null;

		try {
			conn = db.getDBConnection();
			stm = conn.prepareStatement("insert into srikanth.person(name,email,password,gender) values(?,?,?,?)");
			stm.setString(1, person.getName());
			stm.setString(2, person.getEmail());
			stm.setString(3, person.getPassWord());
			stm.setString(4, person.getGender());
			
		int i =	 stm.executeUpdate();
		System.out.println("the value of " +i);
			if(i == 1)
			{
				
				return true;
			}
			return false;
			
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;

		} finally {
			helper.close(conn);
			helper.close(stm);
		}
	}

	public Boolean authPerson(String email, String password) {
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try 
		{
			conn = db.getDBConnection();
			String queryCheck = "SELECT * from srikanth.person WHERE email = ?";
			stm = conn.prepareStatement(queryCheck);
			System.out.println("email printing" + email);
			stm.setString(1, email);
			stm.execute();
			rs = stm.getResultSet();
			if (rs.next()) {
				System.out.println("printing resultset" + rs.getString("password"));

				if (rs.getString("password").equals(password)) {
					return true;
				}
			}
				return false;
			

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			helper.close(conn);
			helper.close(stm);
			helper.close(rs);
		}

	}

	public String authPerson(String email) {

		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			System.out.println("shakalaka baby");
			conn = db.getDBConnection();
			String queryCheck = "SELECT * from srikanth.person WHERE email = ?";
			stm = conn.prepareStatement(queryCheck);
			stm.setString(1, email);
			stm.execute();
			rs = stm.getResultSet();
			if (!rs.next()) {
				System.out.println(" naka babybaby4");
				return "sucess";

			} else {
				return "User already registered";
			}
		} catch (Exception e) {
			return "Connection Problem try after Some time";
		} finally {
			helper.close(conn);
			helper.close(stm);
			helper.close(rs);
		}
	}

}
