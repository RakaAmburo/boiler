package com.boiler.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.boiler.entities.Role;

public class RoleRowMapper implements RowMapper<Role>{

	@Override
	public Role mapRow(ResultSet row, int rowNum) throws SQLException {
		
		Role role = new Role();
		
		role.setId(row.getLong("id"));
		role.setName(row.getString("name"));
		role.setDescription(row.getString("description"));
		
		return role;
	}

}
