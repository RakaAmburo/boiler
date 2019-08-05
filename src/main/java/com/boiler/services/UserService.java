package com.boiler.services;

import java.util.List;

import com.boiler.entities.User;

public interface UserService {
	
	boolean findById(Integer id);
	
	public List<User> getUserList();
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deletUser(Long id);

}
