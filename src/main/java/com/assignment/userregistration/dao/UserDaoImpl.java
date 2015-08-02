package com.assignment.userregistration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.userregistration.model.User;

/*
 * Provides access to an underlying database/persistence storage
 */
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	/**
	 * adds the new user to the database
	 */
	@Override
	public boolean addUser(User user) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();

		return false;
	}

	/**
	 * lists the registered users from database
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getRegisteredUsers() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<User> usersList = session.createCriteria(User.class).list();
		tx.commit();
		session.close();
		return usersList;
	}

	/**
	 * deletes user from database
	 */

	@Override
	public boolean deleteUser(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(User.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
