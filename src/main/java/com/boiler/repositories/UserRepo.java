package com.boiler.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from people", Integer.class);
    }

}
