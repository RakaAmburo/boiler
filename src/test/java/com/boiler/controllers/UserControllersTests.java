package com.boiler.controllers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.boiler.config.security.JwtTokenMockUtil;
import com.boiler.entities.People;
import com.boiler.services.PeopleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllersTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private JwtTokenMockUtil jwtTokenUtil;

	@MockBean
	@Qualifier("userServiceImp")
	private PeopleService userService;

	@Test
	public void testUserList() throws Exception {

		// given
		People user = new People();
		user.setId(Long.valueOf(1));
		user.setFirstName("pablo");
		user.setLastName("paparini");
		user.setBalance(Double.valueOf(100));

		List<People> users = Arrays.asList(user);
		given(userService.getUserList()).willReturn(users);
		
		
		String token = "Bearer "+ jwtTokenUtil.generateMockToken("pablo");

		// when + then
		this.mockMvc.perform(get("/users").header("Authorization", token)).andExpect(status().isOk()).andExpect(
				content().json("[{'id': 1, 'last_name': 'paparini', 'firstName': 'pablo', 'balance': 100.0}]"));
	}

}
