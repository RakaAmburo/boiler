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
	
	public User findByUsername(String userName) {
		String sql = "select id, username, password from users where username = ?";
		RowMapper<User> rowMapper = new UserRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, userName);
	}

	public User getUser(Long id) {
		String sql = "select id, username, password from users where id = ?";
		RowMapper<User> rowMapper = new UserRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	public List<User> getUserList() {

		String sql = "select id, username, password from users";
		RowMapper<User> rowMapper = new UserRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);

	}

	public void addUser(User user) {

		String sql = "INSERT INTO users (username, password) values (?, ?)";
		jdbcTemplate.update(sql, user.getUserName(), user.getPassWord());
	}

	public void updateUser(User user) {
		String sql = "UPDATE users SET username=?, password=?  WHERE id=?";
		jdbcTemplate.update(sql, user.getUserName(), user.getPassWord(), user.getId());
	}

	public void deleteUser(Long id) {
		String sql = "DELETE FROM users WHERE id=?";
		jdbcTemplate.update(sql, id);
	}

}
