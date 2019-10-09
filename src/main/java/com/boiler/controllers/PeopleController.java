package com.boiler.controllers;


import java.util.List;
import java.util.stream.Collectors;

//import javax.sql.DataSource;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boiler.entities.Employee;
import com.boiler.entities.TransferFunds;
import com.boiler.entities.People;
import com.boiler.repositories.InsufficientAccountBalanceException;
import com.boiler.services.PeopleService;


@RestController
@Validated
public class PeopleController extends AbsctractController {
	
	/*@Autowired
    DataSource dataSource;*/

	@Autowired
	@Qualifier("userServiceImp")
	private PeopleService service;

	@GetMapping("/users/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void userInfo(@PathVariable @Pattern(message = "Should provide a number", regexp = ONLY_ALFA) String id) {
		//System.out.println("DATASOURCE = " + dataSource);
		service.findById(1);
	}
	
	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<People> userList(@RequestHeader MultiValueMap<String, String> headers) {
		headers.forEach((key, value) -> {
	        System.out.println(String.format("Header '%s' = %s", key, value.stream().collect(Collectors.joining("|"))));
	    });
		return service.getUserList();
	}
	
	@PostMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public void addUser(@Valid @RequestBody People user) {		
		service.addUser(user);
	}
	
	@PutMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public void updateUser(@Valid @RequestBody People user) {
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
		
		People u1 = new People();
		u1.setId(tf.getOriginId());
		People u2 = new People();
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
	headers	ok
	tokens 	
	lambda
	
	mvn dependency:resolve
    mvn clean install
    mvn spring-boot:run
    mvn test
	*/

}
