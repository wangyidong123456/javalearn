package com.igeek.demo1;

import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserServiceImpl implements UserService {

	public void save() {
		System.out.println("保存用户...");
	}
	
	public void delete() {
		System.out.println("删除用户...");
	}

}
