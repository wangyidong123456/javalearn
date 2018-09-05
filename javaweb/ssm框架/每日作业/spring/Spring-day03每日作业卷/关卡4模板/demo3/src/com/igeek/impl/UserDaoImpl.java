package com.igeek.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.igeek.dao.UserDao;
import com.igeek.domain.User;
import com.igeek.utils.HibernateUtils;

@Repository(value="userDao")
public class UserDaoImpl implements UserDao {
	
	public void save(User user) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(user);
	}

}
