package com.boiler.services;

import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.boiler.entities.User;
import com.boiler.repositories.UserRepo;
import com.boiler.services.imp.UserServiceImp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImpTest {
	
	@Mock
	private UserRepo userRepo;
	
	@InjectMocks
	private UserServiceImp userService;
	
	@Test
    public void whenGetUserList_thenReturnUserList() {
		
		// given
        User user = new User();
        user.setId(Long.valueOf(1));
        user.setFirstName("pablo");
        user.setLastName("paparini");
        user.setBalance(Double.valueOf(100));

        List<User> users = Arrays.asList(user);      
        
        doReturn(users).when(userRepo).getUserList();
        
        // when
        List<User> actualUsers = userService.getUserList();
        

        // then
        assertThat(actualUsers).isEqualTo(users);
        
		
	}
	

}
