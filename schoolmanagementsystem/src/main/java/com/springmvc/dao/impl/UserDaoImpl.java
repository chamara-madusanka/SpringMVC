/*
 * UserDaoImpl.java
 *
 *
 *
 * School management system 
 */
package com.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.UserDao;
import com.springmvc.model.ResponseModel;
import com.springmvc.model.User;
import com.springmvc.model.UserAndRole;
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
	public void addUser(User user) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}

	@Override
	public void addUserRole(UserRole userRole) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(userRole);
		transaction.commit();
		session.close();
	}

	@Override
	public List<UserAndRole> searchUsers(UserAndRole userAndRole) throws Exception {
		String userName = userAndRole.getUsername();
		String password = userAndRole.getPassword();
		String role = userAndRole.getRole();
		boolean enabled = userAndRole.isEnabled();
		User user = new User(userName, password, enabled);
		UserRole userRole = new UserRole(user, role);
		
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserRole.class, "userRole").
				createAlias("userRole.user", "user").
				setProjection(Projections.projectionList().
						add(Projections.groupProperty("role")).
						add(Projections.groupProperty("user.username"), "userName").
						add(Projections.groupProperty("user.enabled"), "enabled"));
		
		criteria.add(Restrictions.eq("user.username", userName)).
					add(Restrictions.eq("user.enabled", enabled)).
					add(Restrictions.eq("userRole.role", role));
		
		List<UserAndRole> userAndRoles = criteria.list();
		
		return userAndRoles;
	}

}
