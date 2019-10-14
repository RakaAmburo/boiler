package com.boiler.controllers;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boiler.entities.Role;
import com.boiler.repositories.RoleRepo;

@RestController
@Validated
public class RoleController {
	
	@Autowired
	private RoleRepo roleRepo;
	
	@GetMapping("/roles")
	@ResponseStatus(HttpStatus.OK)
	public List<Role> getRoles(){
		return roleRepo.getRoleList();
	}
	
	@PostMapping("/role")
	@ResponseStatus(HttpStatus.CREATED)
	public void addUser(@Valid @RequestBody Role role) {		
		roleRepo.addRole(role);
	}
	
	@DeleteMapping("/role/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteRole(@PathVariable String id) {
		roleRepo.deleteRole(Long.parseLong(id));
	}
	
	@GetMapping("/role/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Set<Role> getRolesById(@PathVariable String id){
		return roleRepo.getRoleByUserId(Long.parseLong(id));
	}

}
