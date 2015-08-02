package com.assignment.userregistration.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.userregistration.dao.UserDao;
import com.assignment.userregistration.model.User;

/*
 * Provides the implementation for User Registration services
 */
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	UserDao userDao;

	/**
	 * adds the new user to system
	 */
	@Override
	public boolean addUser(User user) throws Exception {
		user.setRegisteredDate(new SimpleDateFormat("MM-dd-yyyy").format(new Date()));
		return userDao.addUser(user);
	}

	/**
	 * lists the registered users
	 */
	@Override
	public List<User> getRegisteredUsers() throws Exception {
		return userDao.getRegisteredUsers();
	}

	/**
	 * deletes a user
	 */

	@Override
	public boolean deleteUser(long id) throws Exception {
		return userDao.deleteUser(id);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
