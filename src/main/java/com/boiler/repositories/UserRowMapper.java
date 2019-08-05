package com.boiler.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.boiler.entities.User;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet row, int rowNum) throws SQLException {
		
		User user = new User();
		
		user.setId(row.getLong("id"));
		user.setFirstName(row.getString("first_name"));
		user.setLastName(row.getString("last_name"));
		
		return user;
	}

}
