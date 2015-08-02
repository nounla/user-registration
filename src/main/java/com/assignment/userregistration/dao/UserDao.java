package com.assignment.userregistration.dao;

import java.util.List;

import com.assignment.userregistration.model.User;

public interface UserDao {

	public boolean addUser(User user) throws Exception;

	public List<User> getRegisteredUsers() throws Exception;

	public boolean deleteUser(long id) throws Exception;
}
