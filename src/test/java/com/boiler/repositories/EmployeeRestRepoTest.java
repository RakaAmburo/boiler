package com.boiler.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.boiler.entities.Employee;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRestRepoTest {

	private static final String EMPLOYEE_ULR = "http://www.mocky.io/v2/5d4b788b3100005c00a94d9c";

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private EmployeeRestRepo repo;

	@Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {
        Employee emp = new Employee("1", "Ailcar", "2", "15", "no tiene");
        
        doReturn(emp).when(restTemplate).getForObject(EMPLOYEE_ULR, Employee.class);
 
        Employee employee = repo.getEmployeeById();
        
        // then
		assertThat(emp.getEmployeeName()).isEqualTo(employee.getEmployeeName());
	}

}
