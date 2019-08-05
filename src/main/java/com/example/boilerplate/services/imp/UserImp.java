package com.example.boilerplate.services.imp;

import org.springframework.stereotype.Service;

import com.example.boilerplate.services.User;

@Service(value = "userService")
public class UserImp implements User {

	@Override
	public boolean findById(Integer id) {

		System.out.println(id);
		
		return true;

	}

}
