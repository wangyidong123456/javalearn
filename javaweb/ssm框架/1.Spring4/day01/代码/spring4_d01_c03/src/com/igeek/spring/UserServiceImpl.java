package com.igeek.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igeek.IUserDao;
import com.igeek.IUserService;
import com.igeek.UserDaoImpl;

public class UserServiceImpl implements IUserService{
	
	
	private IUserDao userDao;
	
	
	//spring 通过setter方法 给userDao 赋值
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}



	@Override
	public void login() {
		System.out.println("UserServiceImpl -- service层被调用了");
		
		userDao.findByUsernameAndPassowrd();
		
		
	}

}
