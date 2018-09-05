package com.igeek.service;

import com.igeek.dao.AccountDao;

public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void pay(String name1, double money1, String name2, double money2) {
		accountDao.save(name1, money1);
		// 模拟异常
		int a = 10/0;
		accountDao.update(name2, money2);
	}

}
