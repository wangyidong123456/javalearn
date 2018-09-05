package com.igeek.service;

import com.igeek.dao.AccountDao;

public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	/**
	 * 转账的方法
	 */
	public void pay(String from, String to, double money) {
		accountDao.fromMoney(from, money);
		accountDao.toMoney(to, money);
	}

}
