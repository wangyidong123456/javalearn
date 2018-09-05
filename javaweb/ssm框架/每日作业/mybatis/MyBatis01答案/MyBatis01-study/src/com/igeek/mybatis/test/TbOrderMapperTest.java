package com.igeek.mybatis.test;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.igeek.mybatis.dao.TbOrderMapper;
import com.igeek.mybatis.pojo.TbOrder;

public class TbOrderMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		this.sqlSessionFactory = builder.build(inputStream);

	}

	@Test
	public void testSaveTbOrder() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		TbOrderMapper tbOrderMapper = sqlSession.getMapper(TbOrderMapper.class);

		TbOrder tbOrder = new TbOrder();
		tbOrder.setStatus(1);
		tbOrder.setCreateTime(new Date());
		tbOrder.setPaymentType(1);
		tbOrder.setBuyerMessage("好东西");

		tbOrderMapper.saveTbOrder(tbOrder);

		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testQueryTbOrderById() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		TbOrderMapper tbOrderMapper = sqlSession.getMapper(TbOrderMapper.class);

		TbOrder tbOrder = tbOrderMapper.queryTbOrderById(4l);
		System.out.println(tbOrder);

		sqlSession.close();
	}

	@Test
	public void testQueryTbOrderByDate() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		TbOrderMapper tbOrderMapper = sqlSession.getMapper(TbOrderMapper.class);

		Map<String, Object> map = new HashMap<>();
		map.put("startTime", new Date(0l));
		map.put("endTime", new Date());

		List<TbOrder> list = tbOrderMapper.queryTbOrderByDate(map);

		for (TbOrder o : list) {
			System.out.println(o);
		}

		sqlSession.close();
	}

	@Test
	public void testQueryTbOrderByBuyerMessage() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		TbOrderMapper tbOrderMapper = sqlSession.getMapper(TbOrderMapper.class);

		List<TbOrder> list = tbOrderMapper.queryTbOrderByBuyerMessage("好");

		for (TbOrder o : list) {
			System.out.println(o);
		}

		sqlSession.close();
	}

	@Test
	public void testUpdateTbOrderById() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		TbOrderMapper tbOrderMapper = sqlSession.getMapper(TbOrderMapper.class);

		TbOrder tbOrder = new TbOrder();
		tbOrder.setId(3l);
		tbOrder.setStatus(1);

		tbOrderMapper.updateTbOrderById(tbOrder);

		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testUpdateTbOrderByDate() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		TbOrderMapper tbOrderMapper = sqlSession.getMapper(TbOrderMapper.class);

		Map<String, Object> map = new HashMap<>();
		map.put("startTime", new Date(0l));
		map.put("endTime", new Date());

		tbOrderMapper.updateTbOrderByDate(map);

		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testDeleteTbOrderByIdLong() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		TbOrderMapper tbOrderMapper = sqlSession.getMapper(TbOrderMapper.class);

		tbOrderMapper.deleteTbOrderById(1l);

		sqlSession.commit();
		sqlSession.close();
	}
}
