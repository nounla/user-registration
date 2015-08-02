package com.assignment.userregistration.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.assignment.userregistration.model.Status;
import com.assignment.userregistration.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/IntegrationTest-context.xml")
public class IntegrationTest {
	@Autowired
	UserRegistrationController controller;
	User user;

	@Before
	public void setUp() {
		// controller= new UserRegistrationController();
		user = new User();
		user.setName("testName");
		user.setEmail("test@email.com");
	}

	@Test
	public void testAddUser() {

		Status s = controller.addUser(user);
		assertEquals("User added Successfully !", s.getMessage());
		assertEquals(1, s.getCode());
	}

	@Test
	public void testDeleteUser() throws Exception {
		Status s = controller.addUser(user);

		Status s1 = controller.deleteUser(1);
		assertEquals("User deleted Successfully !", s1.getMessage());
		assertEquals(2, s1.getCode());
	}

	@Test
	public void testGetRegisteredUsers() throws Exception {
		Status s = controller.addUser(user);

		List<User> users1 = controller.getRegisteredUsers();
		User user1 = users1.get(0);
		assertEquals("test@email.com", user1.getEmail());
		assertEquals("testName", user1.getName());

	}
}
