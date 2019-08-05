package com.boiler.entities;

import javax.validation.constraints.Pattern;

public class User {

	Long id;
	String firstName;
	String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// @NotBlank(message = "fist name should not be empty!")
	// @Size(min = 3, max = 30, message = "error.field.size")
	@Pattern(regexp="[a-zA-Z]+")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
