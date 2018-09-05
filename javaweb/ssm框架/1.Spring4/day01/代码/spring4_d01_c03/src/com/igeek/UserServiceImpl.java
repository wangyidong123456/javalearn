package com.igeek;

public class UserServiceImpl implements IUserService{

	@Override
	public void login() {
		
		IUserDao userDao = new UserDaoImpl();
		userDao.findByUsernameAndPassowrd();
		System.out.println("UserServiceImpl  -- service²ã±»µ÷ÓÃ");
	}

}
