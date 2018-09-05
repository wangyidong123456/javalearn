package com.igeek.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
	
	public void save(String name, double money) {
		this.getJdbcTemplate().update("insert into account values (null,?,?)", name,money);
	}
	
	public void update(String name, double money) {
		this.getJdbcTemplate().update("update account set money = ? where name = ?", money,name);
	}

}
