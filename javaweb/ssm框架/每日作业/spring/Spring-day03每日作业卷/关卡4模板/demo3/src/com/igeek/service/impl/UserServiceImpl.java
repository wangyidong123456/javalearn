package com.igeek.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igeek.dao.UserDao;
import com.igeek.domain.User;
import com.igeek.service.UserService;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	/**
	 * 没有进行事务管理，使用AOP技术进行事务增强
	 */
	public void save(User user) {
		userDao.save(user);
	}

}
