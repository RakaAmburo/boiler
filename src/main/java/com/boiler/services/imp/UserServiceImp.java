package com.boiler.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boiler.repositories.UserRepo;
import com.boiler.services.UserService;

@Service(value = "userService")
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepo user;

	@Override
	public boolean findById(Integer id) {

		System.out.println("printing result");
		System.out.println(user.count());

		
		return true;

	}

}
