package com.boiler.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.boiler.entities.People;

public class PeopleRowMapper implements RowMapper<People>{

	@Override
	public People mapRow(ResultSet row, int rowNum) throws SQLException {
		
		People user = new People();
		
		user.setId(row.getLong("id"));
		user.setFirstName(row.getString("first_name"));
		user.setLastName(row.getString("last_name"));
		user.setBalance(row.getDouble("balance"));
		
		return user;
	}

}
