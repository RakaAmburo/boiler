package com.boiler;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.boiler.services.PeopleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BoilerplateApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private JwtTokenMockUtil jwtTokenUtil;

	@MockBean
	@Qualifier("userServiceImp")
	private PeopleService userService;

	@Test
	public void testCont() throws Exception {

		given(userService.findById(1)).willReturn(true);

		String token = "Bearer " + jwtTokenUtil.generateMockToken("pablo");

		this.mockMvc.perform(get("/users/2").header("Authorization", token)).andExpect(status().isOk());
	}

}
