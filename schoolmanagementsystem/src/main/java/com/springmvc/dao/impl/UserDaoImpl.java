/*
 * UserDaoImpl.java
 *
 *
 *
 * School management system 
 */
package com.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.UserDao;
import com.springmvc.model.User;
import com.springmvc.model.UserRole;

/**
 * @author Chamara Jayalath
 *
 */
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public User findByUserName(String userName) {
		
		User user = null;
		
		Session session = sessionFactory.openSession();
		List<User> users = session.createCriteria(User.class).add(Restrictions.eq("username", userName)).list();
		if(users.size() > 0) {
			user = users.get(0);
		}
		return user;
	}

	@Override
	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}

	@Override
	public void addUserRole(UserRole userRole) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(userRole);
		transaction.commit();
		session.close();
	}

}
