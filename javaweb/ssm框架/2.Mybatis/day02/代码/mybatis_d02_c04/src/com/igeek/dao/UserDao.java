package com.igeek.dao;

import java.util.List;

import com.igeek.pojo.User;

public interface UserDao {
	public User queryUserById(int id);
					
	public List<User> queryUserByUsername(String name);
	
	public void saveUser(User user);
}
