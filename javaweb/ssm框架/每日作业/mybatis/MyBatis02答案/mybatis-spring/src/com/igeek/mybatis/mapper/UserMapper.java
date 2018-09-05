package com.igeek.mybatis.mapper;

import java.util.List;

import com.igeek.mybatis.pojo.QueryVo;
import com.igeek.mybatis.pojo.User;

public interface UserMapper {
	/**
	 * 根据用户id查询
	 * 
	 * @param id
	 * @return
	 */
	User queryUserById(int id);

	/**
	 * 根据用户名模糊查询用户
	 * 
	 * @param username
	 * @return
	 */
	List<User> queryUserByUsername(String username);

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	void saveUser(User user);

	// 使用用户性别和名字查询用户，并使用if标签、where标签
	public List<User> queryUserBySexAndUsername(User user);

	// 使用foreach标签实现使用多个id查询用户信息
	public List<User> queryUserByIds(QueryVo queryVo);

	// 使用resultMap配置，实现用户-订单的一对多查询"
	public List<User> queryUserOrder();
}
