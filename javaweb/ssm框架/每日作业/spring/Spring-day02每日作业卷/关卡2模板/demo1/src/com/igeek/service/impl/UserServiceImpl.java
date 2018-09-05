package com.igeek.service.impl;

import com.igeek.dao.UserDao;
import com.igeek.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public void save() {
		userDao.save();
	}

}
