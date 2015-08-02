package com.assignment.userregistration.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.assignment.userregistration.model.Status;
import com.assignment.userregistration.model.User;
import com.assignment.userregistration.services.UserRegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * Provides the rest end points for User Registration APIs
 */
@Controller
@RequestMapping("/user")
public class UserRegistrationController {

	@Autowired
	UserRegistrationService userRegistrationService;

	public UserRegistrationService getUserRegistrationService() {
		return userRegistrationService;
	}

	public void setUserRegistrationService(
			UserRegistrationService userRegistrationService) {
		this.userRegistrationService = userRegistrationService;
	}

	static final Logger logger = Logger
			.getLogger(UserRegistrationController.class);

	/**
	 * adds the new user to the system
	 * 
	 * @param user
	 * @return Status
	 */

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addUser(@RequestBody User user) {
		try {
			logger.info("Adding user to the system");
			userRegistrationService.addUser(user);
			return new Status(1, "User added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("Error occur while adding user to the system" + e);
			return new Status(0, e.toString());
		}

	}

	/**
	 * lists all the registered users
	 * 
	 * @return
	 */

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<User> getRegisteredUsers() {

		List<User> usersList = null;
		try {
			usersList = userRegistrationService.getRegisteredUsers();

		} catch (Exception e) {
			logger.error("Error occur while listing users from the system" + e);
			e.printStackTrace();
		}

		return usersList;
	}

	/**
	 * deletes a user
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Status deleteUser(@PathVariable("id") long id) {

		try {
			userRegistrationService.deleteUser(id);
			return new Status(2, "User deleted Successfully !");
		} catch (Exception e) {
			logger.error("Error occur while deleting user from the system" + e);
			return new Status(0, e.toString());
		}

	}
}
