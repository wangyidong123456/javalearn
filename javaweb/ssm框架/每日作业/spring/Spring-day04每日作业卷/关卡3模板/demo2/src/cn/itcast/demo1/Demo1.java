package cn.itcast.demo1;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.service.AccountService;

/**
 * 测试方法
 * @author Administrator
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class Demo1 {
	
	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void run1(){
		accountService.pay("赵四", "王五", 500d);
	}

}
