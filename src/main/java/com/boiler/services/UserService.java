package com.boiler.services;

import java.util.List;

import com.boiler.entities.Employee;
import com.boiler.entities.User;
import com.boiler.repositories.InsufficientAccountBalanceException;

public interface UserService {
	
	boolean findById(Integer id);
	
	public List<User> getUserList();
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deletUser(Long id);
	
	public void transferFund(User fromAccount, User toAccount,
			Double amount) throws InsufficientAccountBalanceException;
	
	public Employee getEmployeeById();

}
