package com.boiler.repositories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.boiler.entities.Role;

@Repository
public class RoleRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Role> getRoleList() {

		String sql = "select id, name, description from roles";
		RowMapper<Role> rowMapper = new RoleRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);

	}

	public void addRole(Role role) {

		String sql = "INSERT INTO roles (name, description) values (?, ?)";
		jdbcTemplate.update(sql, role.getName(), role.getDescription());
	}

	public void deleteRole(Long id) {
		String sql = "DELETE FROM roles WHERE id=?";
		jdbcTemplate.update(sql, id);
	}
	
	public Set<Role> getRoleByUserId(Long id){
		
		String sql = "select r.id, r.name, r.description from roles r join user_roles ur on ur.roleId = 1 where ur.userId = ?";
		RowMapper<Role> rowMapper = new RoleRowMapper();
		return new HashSet<Role>(this.jdbcTemplate.query(sql, rowMapper, id));
	}

}
