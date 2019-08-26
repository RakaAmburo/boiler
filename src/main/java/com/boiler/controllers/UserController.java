package com.boiler.controllers;


import java.util.List;

//import javax.sql.DataSource;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boiler.entities.Employee;
import com.boiler.entities.TransferFunds;
import com.boiler.entities.User;
import com.boiler.repositories.InsufficientAccountBalanceException;
import com.boiler.services.UserService;


@RestController
@Validated
public class UserController extends AbsctractController {
	
	/*@Autowired
    DataSource dataSource;*/

	@Autowired
	@Qualifier("userService")
	private UserService service;

	@GetMapping("/users/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void userInfo(@PathVariable @Pattern(message = "Should provide a number", regexp = ONLY_ALFA) String id) {
		//System.out.println("DATASOURCE = " + dataSource);
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
	
	@PutMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public void updateUser(@Valid @RequestBody User user) {
		service.updateUser(user);
	}
	
	@DeleteMapping("/users/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable String id) {		
		service.deletUser(Long.parseLong(id));
	}
	
	@PutMapping("/users/transfer")
	@ResponseStatus(HttpStatus.OK)
	public void transferFund(@RequestBody TransferFunds tf) throws InsufficientAccountBalanceException {
		
		User u1 = new User();
		u1.setId(tf.getOriginId());
		User u2 = new User();
		u2.setId(tf.getDestId());
		service.transferFund(u1, u2, tf.getAmount());
	}
	
	@GetMapping("/employee")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Employee getEmployee() {
		return service.getEmployeeById();
	}
	
	/*
	transactions OK
	transactions mas complex
	
	tests        OK
	test mas complex
	
	generics     OK(projectOne)
	generics buen ejemplo en este projectoç
	abstract controller  OK
	mensajes de error valiation      OK
	mejorar mensajes de validacion
	levantar properteis              OK
	pool  OK  
	ver si se puede poner jpa sin joder jdbc ALTERNATIVE DATASOURCE
	headers	
	tokens 	
	lambda
	
	mvn dependency:resolve
    mvn clean install
    mvn spring-boot:run
    mvn test
	*/

}
