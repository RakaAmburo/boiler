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
		user.setUserName(row.getString("username"));
		user.setPassWord(row.getString("password"));
		
		return user;
	}
}
