package com.atossyntel.connection;

import com.atossyntel.entities.User;

public class UserDAO implements JDBCInterface{

	@Override
	public User getUser(String userId) {
		UserJDBCOps dbObj = new UserJDBCOps();
		User temp = dbObj.getUser(userId);
		return temp;
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User[] getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
