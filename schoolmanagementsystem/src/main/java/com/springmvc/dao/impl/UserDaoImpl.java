/*
 * UserDaoImpl.java
 *
 *
 *
 * School management system 
 */
package com.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
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
import com.springmvc.model.SearchUserModel;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<SearchUserModel> searchUsers(SearchUserModel searchUserModel) throws Exception {
		String userName = searchUserModel.getUsername();
		String role = searchUserModel.getRole();
		boolean enabled = searchUserModel.isEnabled();

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
		
		List<Object> tmpList = criteria.list();
		
		List<SearchUserModel> searchUserModels = new ArrayList<>();
		
		for(Object tmp : tmpList) {
			@SuppressWarnings("unused")
			String username = ((SearchUserModel)tmp).getUsername();
			String roleuser = ((SearchUserModel)tmp).getRole();
		}
		
		return searchUserModels;
	}

}
