package com.atossyntel.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.atossyntel.entities.User;

public class UserJDBCOps {
	private Connection con;
	private Statement st;
	
	public UserJDBCOps() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Student_Performance","Student_Performance");
			st = con.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 				             
	}
	
	public User getUser(String userId) {
		try{
                System.out.println(userId);
		ResultSet rs = st.executeQuery("SELECT * FROM users WHERE USER_ID= " +  "'" + userId + "'");
                User user;
                while(rs.next()) {
                    user = new User(rs.getString("USER_ID"), rs.getString("PASSWORD"), rs.getString("ISADMIN"));
                    return user;
                }
		} catch(SQLException ex) {
			ex.getMessage();
			return new User();
		}
                return new User();
	}
	
	public boolean addUser(User user) {
		try {
                        st.executeQuery("INSERT INTO USERS (" + user.getUserId() + ", " + user.getPassword() + ", " + user.getIsAdmin());
			return true;
		} catch(SQLException ex) {
			ex.getMessage();
			return false;
		}
	}
	
	public boolean deleteUser(String userId) {
		try {
			st.executeQuery("DELETE FROM USERS WHERE user_id=" + userId);
			return true;
		}catch(SQLException ex) {
			ex.getMessage();
			return false;
		}
	}
	
	public boolean updateUser(User user) {
		try {
			st.executeQuery("UPDATE users SET(user_id=" + user.getUserId() + ", password= " + user.getPassword() + ", isadmin=" + user.getIsAdmin());
			return true;
		} catch(SQLException ex) {
			ex.getMessage();
			return false;
		}
	}
	
	public ArrayList<User> getAllUsers(){
		try {
			ResultSet rs = st.executeQuery("SELECT * FROM users");
			return new ArrayList<>();
		} catch(SQLException ex) {
			ex.getMessage();
			return new ArrayList<>();
		}
	}
}
