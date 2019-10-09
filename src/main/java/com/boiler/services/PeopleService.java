package com.boiler.services;

import java.util.List;

import com.boiler.entities.Employee;
import com.boiler.entities.People;
import com.boiler.repositories.InsufficientAccountBalanceException;

public interface PeopleService {
	
	boolean findById(Integer id);
	
	public List<People> getUserList();
	
	public void addUser(People user);
	
	public void updateUser(People user);
	
	public void deletUser(Long id);
	
	public void transferFund(People fromAccount, People toAccount,
			Double amount) throws InsufficientAccountBalanceException;
	
	public Employee getEmployeeById();

}
