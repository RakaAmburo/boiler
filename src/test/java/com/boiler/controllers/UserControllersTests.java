package com.boiler.controllers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.boiler.entities.User;
import com.boiler.services.UserService;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest
public class UserControllersTests {
	
	
	@Autowired
    private MockMvc mockMvc;
	
	
	@MockBean
	@Qualifier("userService")
    private UserService userService;
	
	@Test
	public void testUserList() throws Exception {
		
		
		// given
        User user = new User();
        user.setId(Long.valueOf(1));
        user.setFirstName("pablo");
        user.setLastName("paparini");
        user.setBalance(Double.valueOf(100));

        List<User> users = Arrays.asList(user);
        given(userService.getUserList()).willReturn(users);

        // when + then
        this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1,'firstName': 'pablo', 'last_name': 'paparini', 'balance': 100.0}]"));
	}

}
