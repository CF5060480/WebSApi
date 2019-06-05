package com.atossyntel.connection;

import com.atossyntel.entities.User;

public interface JDBCInterface {
	public User getUser(String userId);
	public void deleteUser(String userId);
	public void updateUser(User user);
	public User[] getAllUsers();
	public void addUser(User user);
}
