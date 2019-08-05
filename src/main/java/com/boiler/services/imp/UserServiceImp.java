package com.boiler.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boiler.entities.User;
import com.boiler.repositories.UserRepo;
import com.boiler.services.UserService;

@Service(value = "userService")
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepo repo;

	@Override
	public boolean findById(Integer id) {

		System.out.println("printing result");
		System.out.println(repo.count());

		repo.getUserList().stream().forEach(item -> System.out.println(item));

		return true;

	}

	@Override
	public List<User> getUserList() {
		List<User> users = repo.getUserList();
		return users;
	}

	@Override
	public void addUser(User user) {
		repo.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		repo.updateUser(user);		
	}

	@Override
	public void deletUser(Long id) {
		repo.deleteUser(id);
	}

}
