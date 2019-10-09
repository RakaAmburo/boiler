package com.boiler.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boiler.entities.Employee;
import com.boiler.entities.People;
import com.boiler.repositories.EmployeeRestRepo;
import com.boiler.repositories.InsufficientAccountBalanceException;
import com.boiler.repositories.PeopleRepo;
import com.boiler.services.PeopleService;

@Service(value = "userServiceImp")
public class PeopleServiceImp implements PeopleService {

	@Autowired
	private PeopleRepo repo;
	
	@Autowired
	private EmployeeRestRepo empRepo;

	@Override
	public boolean findById(Integer id) {

		System.out.println("printing result");
		System.out.println(repo.count());

		repo.getUserList().stream().forEach(item -> System.out.println(item.getFirstName()));

		return true;

	}

	@Override
	public List<People> getUserList() {
		List<People> users = repo.getUserList();
		return users;
	}

	@Override
	public void addUser(People user) {
		repo.addUser(user);
	}

	@Override
	public void updateUser(People user) {
		repo.updateUser(user);		
	}

	@Override
	public void deletUser(Long id) {
		repo.deleteUser(id);
	}
	
	@Transactional
	public void transferFund(People fromAccount, People toAccount,
			Double amount) throws InsufficientAccountBalanceException {
		
		repo.withdraw(fromAccount, toAccount, amount);
		
		repo.deposit(fromAccount, toAccount, amount);
	}
	
	@Override
	public Employee getEmployeeById(){
		
		Employee emp = empRepo.getEmployeeById();
		
		return emp;
		
	}

}
