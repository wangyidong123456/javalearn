package com.igeek.mapper;

import java.util.List;

import com.igeek.pojo.User;

public interface UserMapper {
	public User queryUserById(int id);
					
	public List<User> queryUserByUsername(String name);
	
	public void saveUser(User user);
}
