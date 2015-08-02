package com.assignment.userregistration.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.assignment.userregistration.model.Status;
import com.assignment.userregistration.model.User;
import com.assignment.userregistration.services.UserRegistrationService;

public class UserRegistrationControllerTest {
	UserRegistrationController controller;
	UserRegistrationService serviceMock;
	User user;

	@Before
	public void setUp() {
		serviceMock = EasyMock.createMock(UserRegistrationService.class);
		controller = new UserRegistrationController();
		controller.setUserRegistrationService(serviceMock);
		user = new User();
		user.setName("testName");
		user.setEmail("test@email.com");
	}

	@Test
	public void testAddUser() throws Exception {
		EasyMock.expect(serviceMock.addUser(user)).andReturn(true);
		EasyMock.replay(serviceMock);
		Status s = controller.addUser(user);
		assertEquals("User added Successfully !", s.getMessage());
		assertEquals(1, s.getCode());
	}

	@Test
	public void testDeleteUser() throws Exception {
		EasyMock.expect(serviceMock.deleteUser(new Long(1))).andReturn(true);
		EasyMock.replay(serviceMock);
		Status s = controller.deleteUser(1);
		assertEquals("User deleted Successfully !", s.getMessage());
		assertEquals(2, s.getCode());
	}

	@Test
	public void testGetRegisteredUsers() throws Exception {
		List<User> users = new ArrayList<User>();
		users.add(user);
		EasyMock.expect(serviceMock.getRegisteredUsers()).andReturn(users);
		EasyMock.replay(serviceMock);
		List<User> users1 = controller.getRegisteredUsers();
		User user1 = users1.get(0);
		assertEquals("test@email.com", user1.getEmail());
		assertEquals("testName", user1.getName());

	}

}
