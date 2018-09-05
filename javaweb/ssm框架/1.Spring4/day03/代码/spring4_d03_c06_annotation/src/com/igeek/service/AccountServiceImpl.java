package com.igeek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igeek.dao.IAccountDao;

@Service("accountService")
@Transactional//会对该类中，所有的共有的方法，自动加上事务--全局的设置，默认是可写
//掌握操作的业务层
public class AccountServiceImpl implements IAccountService{
	
	//注入dao
	@Autowired
	private IAccountDao accountDao;


	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	@Transactional(readOnly=true)//使用局部覆盖全局的
	public void findAccount(){
		System.out.println("查询帐号的信息了");
	}



	//转账操作的业务逻辑
	public void transfer(String outName,String inName,Double money){
		//调用dao层
		//先取出
		accountDao.out(outName, money);
		//再转入
		accountDao.in(inName, money);
	}

}

