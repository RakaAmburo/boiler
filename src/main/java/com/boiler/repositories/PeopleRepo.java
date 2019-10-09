package com.boiler.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.boiler.entities.People;

@Repository
public class PeopleRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${queries.users.selectAll}")
	private String selectAllQueryList;

	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from people", Integer.class);
	}
	
	public People getUser(Long id) {
		String sql = "select id, first_name, last_name, balance from people where id = ?";
		RowMapper<People> rowMapper = new PeopleRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	public List<People> getUserList() {

		String sql = selectAllQueryList;
		RowMapper<People> rowMapper = new PeopleRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);

	}

	public void addUser(People user) {

		String sql = "INSERT INTO people (first_name, last_name, balance) values (?, ?, ?)";
		jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getBalance());
	}
	
	public void updateUser(People user) {
		String sql = "UPDATE people SET first_name=?, last_name=?, balance=? WHERE id=?";
	    jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getBalance(), user.getId());
	}
	
	public void deleteUser(Long id) {
		String sql = "DELETE FROM people WHERE id=?";
		jdbcTemplate.update(sql, id);
	}
	
	public void withdraw(People fromAccount, People toAccount, Double amount) throws InsufficientAccountBalanceException {
		People accountFromDb = getUser(fromAccount.getId());

		Double accountBalance = accountFromDb.getBalance() - amount;
		if (accountFromDb.getBalance() >= amount) {
			String SQL = "UPDATE people set balance=? WHERE id=?";
			int update = jdbcTemplate.update(SQL, accountBalance,
					fromAccount.getId());
			if (update > 0) {
				System.out.println("Amount Rs:" + amount
						+ " is tranferred from Account No:"
						+ fromAccount.getId() + " to Account No:"
						+ toAccount.getId());
			}
		} else {
			throw new InsufficientAccountBalanceException(
					"Insufficient account balance");
		}
	}
	
	public void deposit(People fromAccount, People toAccount, Double amount) {
		People accountFromDb = getUser(toAccount.getId());
		Double accountBalance = accountFromDb.getBalance()+amount;
		String SQL="UPDATE people set balance=? WHERE id=?";
		int update = jdbcTemplate.update(SQL, accountBalance,toAccount.getId());
		if(update>0){
			System.out.println("Amount Rs:"+amount+" is deposited in Account No:"+toAccount.getId());
		}
	}

}
