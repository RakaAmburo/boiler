package com.boiler.controllers;


import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boiler.services.UserService;

@RestController
@Validated
public class User {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@GetMapping("/users/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void userInfo(@PathVariable @Pattern(message = "saranguin not funkin", regexp = "^[0-9]+$") String id) {
		userService.findById(1);
	}

}
