package com.boiler.config.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenMockUtil {

	@Autowired
	private TokenProvider jwtTokenUtil;

	public String generateMockToken(String name) {

		Authentication auth = new Authentication() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return name;
			}

			@Override
			public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean isAuthenticated() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public Object getPrincipal() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object getDetails() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object getCredentials() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
			}
		};
		
		return "Bearer "+ jwtTokenUtil.generateToken(auth);

	}

}
