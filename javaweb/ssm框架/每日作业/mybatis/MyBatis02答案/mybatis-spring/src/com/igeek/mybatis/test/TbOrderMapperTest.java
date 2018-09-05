package com.igeek.mybatis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igeek.mybatis.mapper.TbOrderMapper;
import com.igeek.mybatis.pojo.QueryVo;
import com.igeek.mybatis.pojo.TbOrder;
import com.igeek.mybatis.pojo.TbOrderUser;
import com.igeek.mybatis.pojo.User;

public class TbOrderMapperTest {
	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		this.context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	public void testQueryTbOrderCount() {
		TbOrderMapper tbOrderMapper = context.getBean(TbOrderMapper.class);

		int count = tbOrderMapper.queryTbOrderCount();

		System.out.println(count);
	}

	@Test
	public void testQueryTbOrderByQueryVo() {
		TbOrderMapper tbOrderMapper = context.getBean(TbOrderMapper.class);

		QueryVo queryVo = new QueryVo();
		User user = new User();
		user.setId(1);

		queryVo.setUser(user);

		List<TbOrder> list = tbOrderMapper.queryTbOrderByQueryVo(queryVo);

		System.out.println(list.size());

	}

	@Test
	public void testQueryTbOrderUser() {
		TbOrderMapper tbOrderMapper = context.getBean(TbOrderMapper.class);

		Map<String, Object> map = new HashMap<>();
		map.put("min", 100);
		map.put("max", 300);

		List<TbOrderUser> list = tbOrderMapper.queryTbOrderUser(map);

		for (TbOrderUser tbOrderUser : list) {
			System.out.println(tbOrderUser.getUsername());
			System.out.println(tbOrderUser.getAddress());
		}

	}

	@Test
	public void testQueryTbOrder() {
		TbOrderMapper tbOrderMapper = context.getBean(TbOrderMapper.class);

		Map<String, Object> map = new HashMap<>();
		map.put("min", 100);
		map.put("max", 300);

		List<TbOrder> list = tbOrderMapper.queryTbOrder(map);

		for (TbOrder tbOrder : list) {
			System.out.println(tbOrder.getUser().getUsername());
			System.out.println(tbOrder.getUser().getAddress());
		}
	}

	@Test
	public void testQueryUserById() {
		TbOrderMapper tbOrderMapper = context.getBean(TbOrderMapper.class);
		
		User user = tbOrderMapper.queryUserById(1l);
		
		
		List<TbOrder> list = user.getTbOrders();
		
		for (TbOrder tbOrder : list) {
			
			System.out.println(tbOrder);
		}
	}

}
