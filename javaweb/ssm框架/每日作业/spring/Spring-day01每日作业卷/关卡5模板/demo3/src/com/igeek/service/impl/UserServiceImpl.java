package com.igeek.service.impl;

import com.igeek.dao.UserDao;
import com.igeek.domain.User;
import com.igeek.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void save(User user) {
		userDao.save(user);
	}

}
