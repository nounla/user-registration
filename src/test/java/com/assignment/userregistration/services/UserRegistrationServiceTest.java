package com.assignment.userregistration.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.assignment.userregistration.dao.UserDao;
import com.assignment.userregistration.model.User;

public class UserRegistrationServiceTest {
	UserDao userDao;
	UserRegistrationServiceImpl service;
	User user;

	@Before
	public void setUp() {
		userDao = EasyMock.createMock(UserDao.class);
		service = new UserRegistrationServiceImpl();
		service.setUserDao(userDao);
		user = new User();
		user.setName("testName");
		user.setEmail("test@email.com");

	}

	@Test
	public void testAddUser() throws Exception {
		EasyMock.expect(userDao.addUser(user)).andReturn(true);
		EasyMock.replay(userDao);
		assertTrue(service.addUser(user));
	}

	@Test
	public void testDeleteUser() throws Exception {
		EasyMock.expect(userDao.deleteUser(new Long(1))).andReturn(true);
		EasyMock.replay(userDao);
		assertTrue(service.deleteUser(1));
	}

	@Test
	public void testGetRegisteredUsers() throws Exception {
		List<User> users = new ArrayList<User>();
		users.add(user);
		EasyMock.expect(userDao.getRegisteredUsers()).andReturn(users);
		EasyMock.replay(userDao);
		List<User> users1 = service.getRegisteredUsers();
		User user1 = users1.get(0);
		assertEquals("test@email.com", user1.getEmail());
		assertEquals("testName", user1.getName());

	}
}
