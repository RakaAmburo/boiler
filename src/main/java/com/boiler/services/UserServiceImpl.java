package com.boiler.services;

import com.boiler.entities.User;
import com.boiler.entities.UserDto;
import com.boiler.repositories.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepo userDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassWord(), getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
		/*
		 * Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		 * user.getRoles().forEach(role -> { //authorities.add(new
		 * SimpleGrantedAuthority(role.getName())); authorities.add(new
		 * SimpleGrantedAuthority("ROLE_" + role.getName()));
		 * 
		 * });
		 */
		//return authorities;
		return new HashSet<SimpleGrantedAuthority>(Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.getUserList().iterator().forEachRemaining(list::add);
		return list;
	}

	
	public void delete(long id) {
		userDao.deleteUser(id);
	}


	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	
	@Cacheable(value = "userbyid", key = "#id")
	public User findById(Long id) {
		LOGGER.info("find one user not cached!");
		return userDao.getUser(id);
	}

    public void save(UserDto user) {
	    User newUser = new User();
	    newUser.setUserName(user.getUsername());
	    newUser.setPassWord(bcryptEncoder.encode(user.getPassword()));
        userDao.addUser(newUser);
    }
}
