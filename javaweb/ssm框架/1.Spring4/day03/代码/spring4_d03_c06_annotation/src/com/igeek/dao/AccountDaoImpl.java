package com.igeek.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
@Repository("accountDao")
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
	@Autowired//当初始化dao的时候，会调用该方法啊，通过set方法的形参注入数据源
	//方法名无所谓
	public void setDi(DataSource dataSource){
		//调用父类的方法
		super.setDataSource(dataSource);		
	}


	//（存入）转入
		public void in(String name,Double money){
			String sql="update t_account set money1 = money+ ? where name = ?";
			super.getJdbcTemplate().update(sql, money,name);
		}
		
		//（取出）转出
		public void out(String name,Double money){
			String sql="update t_account set money = money- ? where name = ?";
			super.getJdbcTemplate().update(sql, money,name);
		}


}
