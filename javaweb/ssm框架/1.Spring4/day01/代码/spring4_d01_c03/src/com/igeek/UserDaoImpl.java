package com.igeek;

public class UserDaoImpl implements IUserDao{

	@Override
	public void findByUsernameAndPassowrd() {
		System.out.println("UserDaoImpl dao层被调用了");
	}

}
