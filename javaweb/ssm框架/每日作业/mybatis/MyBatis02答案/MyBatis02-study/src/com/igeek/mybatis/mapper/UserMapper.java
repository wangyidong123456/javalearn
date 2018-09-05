package com.igeek.mybatis.mapper;

import java.util.List;

import com.igeek.mybatis.pojo.QueryVo;
import com.igeek.mybatis.pojo.User;

public interface UserMapper {

	/**
	 * 根据包装pojo查询用户
	 * 
	 * @param queryVo
	 * @return
	 */
	public List<User> queryUserByQueryVo(QueryVo queryVo);

	/**
	 * 查询数据库数据条数
	 * 
	 * @return
	 */
	public int queryUserCount();

	/**
	 * 根据用户名和性别查询
	 * 
	 * @param user
	 * @return
	 */
	public List<User> queryUserBySexAndUsername(User user);

	/**
	 * 测试foreach标签，解析集合
	 * 
	 * @param queryVo
	 * @return
	 */
	public List<User> queryUserByIds(QueryVo queryVo);

	/**
	 * 一对多关联查询
	 * 
	 * @return
	 */
	public List<User> queryUserOrder();
}
