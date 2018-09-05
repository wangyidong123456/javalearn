package com.igeek.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.igeek.mybatis.pojo.QueryVo;
import com.igeek.mybatis.pojo.TbOrder;
import com.igeek.mybatis.pojo.TbOrderUser;
import com.igeek.mybatis.pojo.User;

public interface TbOrderMapper {

	// 实现查询tb_order的数据条数
	public int queryTbOrderCount();

	// 使用包装对象，根据用户id查询该用户的所有已付款的订单
	public List<TbOrder> queryTbOrderByQueryVo(QueryVo queryVo);

	// 根据订单金额payment查询订单，一对一关联用户数据，使用自定义pojo实现
	public List<TbOrderUser> queryTbOrderUser(Map<String, Object> map);

	// 根据订单金额payment查询订单，要一对一关联用户数据，使用resultMap实现
	public List<TbOrder> queryTbOrder(Map<String, Object> map);

	// 根据id查询user，需要一对多关联tb_order
	public User queryUserById(Long id);

}
