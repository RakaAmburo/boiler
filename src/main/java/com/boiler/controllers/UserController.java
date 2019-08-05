package com.boiler.controllers;


import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boiler.entities.User;
import com.boiler.services.UserService;

@RestController
@Validated
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService service;

	@GetMapping("/users/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void userInfo(@PathVariable @Pattern(message = "saranguin not funkin", regexp = "^[0-9]+$") String id) {
		service.findById(1);
	}
	
	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<User> userList() {
		return service.getUserList();
	}
	
	@PostMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public void addUser(@Valid @RequestBody User user) {		
		service.addUser(user);
	}

}
