package com.igeek.service.impl;

import com.igeek.service.UserService;

import com.igeek.dao.UserDao;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void save() {
		userDao.save();
	}

}
