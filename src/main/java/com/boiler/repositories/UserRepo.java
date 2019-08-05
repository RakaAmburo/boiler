package com.boiler.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.boiler.entities.User;

@Repository
public class UserRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from people", Integer.class);
	}

	public List<User> getUserList() {

		String sql = "select id, first_name, last_name from people";
		RowMapper<User> rowMapper = new UserRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);

	}

	public void addUser(User user) {

		String sql = "INSERT INTO people (first_name, last_name) values (?, ?)";
		jdbcTemplate.update(sql, user.getFirstName(), user.getLastName());
	}
	
	public void updateUser(User user) {
		String sql = "UPDATE people SET first_name=?, last_name=? WHERE id=?";
	    jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getId());
	}
	
	public void deleteUser(Long id) {
		String sql = "DELETE FROM people WHERE id=?";
		jdbcTemplate.update(sql, id);
	}

}
