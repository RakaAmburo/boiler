package com.boiler.entities;

import org.springframework.data.annotation.Id;

public class User {
	
	@Id
    Long id;
    String firstName;
    String lastName;

}
