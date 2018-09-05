package com.igeek.mapper;

import java.util.List;

import com.igeek.pojo.Order;
import com.igeek.pojo.OrderUser;
import com.igeek.pojo.User;
import com.igeek.vo.QueryVo;

public interface UserMapper {
	public List<User> queryUserByQueryVo(QueryVo queryVo);
	
	public int queryUserCount();
	
	public List<User> queryUserByWhere(User user);
	
	public List<User> queryUserByIds(QueryVo queryVo);
	
	public List<OrderUser> queryOne2One();
	
	public List<Order> queryOrderUserResultMap();
	
	public List<User> queryUserOrder();
}
