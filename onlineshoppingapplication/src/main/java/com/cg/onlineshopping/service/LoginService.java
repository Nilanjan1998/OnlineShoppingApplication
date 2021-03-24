package com.cg.onlineshopping.service;

import com.cg.onlineshopping.entities.User;

public interface LoginService {

	public User addUser(User user);
	
	public User removeUser(int userId);
	
	public User validateUser(int userId);
	
	public User signOut(User user);
}
