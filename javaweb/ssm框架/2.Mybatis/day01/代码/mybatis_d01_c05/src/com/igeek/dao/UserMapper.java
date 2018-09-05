package com.igeek.dao;

import java.util.List;

import com.igeek.pojo.User;

public interface UserMapper {
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	public User queryUserById(int id);
	
	public List<User> queryUserByUsername(String username);
	
	public void saveUser(User user);
}
