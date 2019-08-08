package com.boiler.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.boiler.entities.Employee;

@Repository
public class EmployeeRestRepo {
	
	private static final String EMPLOYEE_ULR = "http://www.mocky.io/v2/5d4b788b3100005c00a94d9c";
	
	@Autowired
    private RestTemplate restTemplateIV;
	
	// header y seguridad en contructor
    public Employee getEmployeeById() {
    	
        Employee emp = restTemplateIV.getForObject(EMPLOYEE_ULR, Employee.class);

    	return emp;
    }

}
