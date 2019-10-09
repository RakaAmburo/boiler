package com.boiler.services;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.boiler.entities.People;
import com.boiler.repositories.PeopleRepo;
import com.boiler.services.imp.PeopleServiceImp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImpTest {
	
	@Mock
	private PeopleRepo userRepo;
	
	@InjectMocks
	private PeopleServiceImp userService;
	
	@Test
    public void whenGetUserList_thenReturnUserList() {
		
		// given
        People user = new People();
        user.setId(Long.valueOf(1));
        user.setFirstName("pablo");
        user.setLastName("paparini");
        user.setBalance(Double.valueOf(100));

        List<People> users = Arrays.asList(user);      
        
        doReturn(users).when(userRepo).getUserList();
        
        // when
        List<People> actualUsers = userService.getUserList();
        

        // then
        assertThat(actualUsers).isEqualTo(users);
        
		
	}
	

}
