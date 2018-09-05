package com.igeek.mybatis.dao;

import java.util.List;

import com.igeek.mybatis.pojo.User;

public interface UserMapper {

	public User queryUserById(int id);

	public List<User> queryUserByUserName(String userName);

	public void saveUser(User user);

	public void updateUser(User user);

	public void deleteUserById(int id);
}
